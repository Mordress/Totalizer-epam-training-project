package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends AuthorizedUserAction {

    private static Logger logger = Logger.getLogger(LogoutAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        User user = getAuthorizedUser();
        logger.info(String.format("user \"%s\" is logged out", user.getLogin()));
        request.getSession(false).invalidate();
        return new Forward("/login.html");
    }
}
