package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Logging out user from web-app.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class LogoutAction extends AuthorizedUserAction {

    private static Logger logger = Logger.getLogger(LogoutAction.class);

    /** Process user's quit from web-app. Delete HTTP session.
     * @param request incapsulating of HTTP request
     * @param response incapsulating of HTTP response
     * @return forward to login page.
     * @throws PersistentException - if service and dao layers produce this exception */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        User user = getAuthorizedUser();
        logger.info(String.format("user \"%s\" is logged out", user.getLogin()));
        request.getSession(false).invalidate();
        return new Forward("/login.html");
    }
}
