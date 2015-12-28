package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.UserService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Process user's input for change his personal data.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class ProfileSaveAction extends AuthorizedUserAction {

    private static Logger logger = Logger.getLogger(ProfileSaveAction.class);

    /** Checking user's input old and new passwords, if that correct - changes it.
     * @param request incapsulating of HTTP request
     * @param response incapsulating of HTTP response
     * @return forward to this page.
     * @throws PersistentException - if service and dao layers produce this exception */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Action.Forward forward = new Action.Forward("/profile/edit.html");
        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String confirmPassword = request.getParameter("confirm-password");
        User authorizedUser = getAuthorizedUser();
        if (oldPassword != null && newPassword != null && confirmPassword != null) {
            if (!newPassword.equals(confirmPassword)) {
                forward.getAttributes().put("message", "Ошибка при наборе нового пароля");
                logger.info(String.format("User \"%s\" tried to change password and specified the incorrect new password", authorizedUser.getLogin()));
            } else {
                UserService service = factory.getService(UserService.class);
                User user = service.findUser(authorizedUser.getLogin(), oldPassword);
                if (user != null) {
                    user.setPassword(newPassword);
                    service.save(user);
                    forward.getAttributes().put("message", "Пароль успешно изменён");
                    logger.info(String.format("User \"%s\" changed password", authorizedUser.getLogin()));
                } else {
                    forward.getAttributes().put("message", "Старый пароль неопознан");
                    logger.info(String.format("User \"%s\" tried to change password and specified the incorrect previous password", authorizedUser.getLogin()));
                }
            }
        } else {
            logger.warn(String.format("Incorrect data was found when user \"%s\" tried to change password", authorizedUser.getLogin()));
        }

        return forward;
    }
}
