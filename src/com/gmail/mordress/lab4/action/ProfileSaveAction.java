package com.gmail.mordress.lab4.action;

import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileSaveAction extends AuthorizedUserAction {

    private static Logger logger = Logger.getLogger(ProfileSaveAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Action.Forward forward = new Action.Forward("/profile/edit.html");
        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        User authorizedUser = getAuthorizedUser();
        if(oldPassword != null && newPassword != null) {
            UserService service = factory.getService(UserService.class);
            User user = service.findUser(authorizedUser.getLogin(), oldPassword);
            if(user != null) {
                user.setPassword(newPassword);
                service.save(user);
                forward.getAttributes().put("message", "Пароль успешно изменён");
                logger.info(String.format("User \"%s\" changed password", authorizedUser.getLogin()));
            } else {
                forward.getAttributes().put("message", "Старый пароль неопознан");
                logger.info(String.format("User \"%s\" tried to change password and specified the incorrect previous password", authorizedUser.getLogin()));
            }
        } else {
            logger.warn(String.format("Incorrect data was found when user \"%s\" tried to change password", authorizedUser.getLogin()));
        }
        return forward;
    }
}
