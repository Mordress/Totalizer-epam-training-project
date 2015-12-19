package com.gmail.mordress.lab4.action;

import com.gmail.mordress.lab4.domain.Role;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.UserService;
import com.gmail.mordress.lab4.utils.Hasher;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class RegistrationSaveAction extends MainAction {

    private static Logger logger = Logger.getLogger(LogoutAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Action.Forward forward = new Action.Forward("/login.html");
        String userFirstName = request.getParameter("firstname");
        String userLastName = request.getParameter("lastname");
        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");
        String userConfirmPassword = request.getParameter("confpassword");
        String userEmail = request.getParameter("email");
        try {
            //TODO сделать валидацию входных данных
            UserService userService = factory.getService(UserService.class);
            if (!userPassword.equals(userConfirmPassword)) {
                forward.getAttributes().put("message", "Пользователь не создан: введенные пароли не совпадают");
            }
            else if (userService.checkUniqueLogin(userLogin)) {
                User user = new User();
                user.setLogin(userLogin);
                user.setPassword(Hasher.SHA256(userPassword));
                user.setFirstName(userFirstName);
                user.setLastName(userLastName);
                user.setRole(Role.USER);
                user.setEmail(userEmail);
                user.setCashAmount(new BigDecimal("1000"));
                userService.save(user);
                forward.getAttributes().put("message", "Пользователь успешно создан.");
                logger.info("Пользователь " + user.getLogin() + " успешно создан.");
            } else {
                forward.getAttributes().put("message", "Пользователь с таким логином уже существует");
                logger.error("Не удалось создать пользователя: " + userLogin + ". Причина: такой пользователь уже существует.");
            }
        } catch (PersistentException | NullPointerException e) {
            forward.getAttributes().put("message", "Не удалось создать пользователя с такими данным");
            logger.error("Не удалось создать пользователя: " + userLogin + ". Причина: введены некорректные данные.");
        }
        return forward;
    }
}
