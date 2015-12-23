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

public class RegistrationSaveAction extends Action {

    private static Logger logger = Logger.getLogger(RegistrationSaveAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Action.Forward forwardSuccesfull = new Action.Forward("/login.html");
        Action.Forward forwardFailed = new Action.Forward("/registration.html");
        String userFirstName = request.getParameter("firstname");
        String userLastName = request.getParameter("lastname");
        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");
        String userConfirmPassword = request.getParameter("confpassword");
        String userEmail = request.getParameter("email");
        try {
            UserService userService = factory.getService(UserService.class);
            if (!userPassword.equals(userConfirmPassword)) {
                forwardFailed.getAttributes().put("message", "Пользователь не создан: введенные пароли не совпадают");
                return forwardFailed;
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
                forwardSuccesfull.getAttributes().put("message", "Пользователь успешно создан.");
                logger.info("User " + user.getLogin() + " successful created.");
            } else {
                forwardFailed.getAttributes().put("message", "Пользователь с таким логином уже существует");
                logger.error("Can not create user: " + userLogin + ". Reason: user already exists.");
                return forwardFailed;
            }
        } catch (PersistentException | NullPointerException e) {
            forwardFailed.getAttributes().put("message", "Не удалось создать пользователя с такими данным");
            logger.error("Can not create user: " + userLogin + ". Reason: incorrect input.");
            return forwardFailed;
        }
        return forwardSuccesfull;
    }
}
