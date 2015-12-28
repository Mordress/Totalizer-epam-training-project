package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.Role;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginAction extends Action {

    private static Logger logger = Logger.getLogger(LoginAction.class);

    private static Map<Role, List<MenuItem>> menu = new ConcurrentHashMap<>();

    static {
        menu.put(Role.BOOKMAKER, new ArrayList<>(Arrays.asList(
                new MenuItem("/bets/fix.html", "победы"),
                new MenuItem("/horses.html", "лошади")
        )));
        menu.put(Role.ADMINISTRATOR, new ArrayList<>(Arrays.asList(
                new MenuItem("/races/list.html", "забеги"),
                new MenuItem("/horses.html", "лошади")
        )));
        menu.put(Role.USER, new ArrayList<>(Arrays.asList(
                new MenuItem("/bets/list.html", "ставки"),
                new MenuItem("/horses.html", "лошади")
        )));
    }

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null) {
            UserService service = factory.getService(UserService.class);
            User user = service.findUser(login, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                session.setAttribute("menu", menu.get(user.getRole()));
                logger.info(String.format("user \"%s\" is logged in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
                return new Forward("/index.html");
            } else {
                request.setAttribute("message", "Неправильный логин или пароль");
                logger.info(String.format("user \"%s\" unsuccessfully tried to log in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
            }
        }
        return null;
    }
}
