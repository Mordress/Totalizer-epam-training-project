package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.exceptions.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Provides appropriate main action for each user based his role.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class MainAction extends AuthorizedUserAction {

    /** Forwarding user to appropriate main page.
     * @param request incapsulating of HTTP request
     * @param response incapsulating of HTTP response
     * @return forward to main page for that user.
     * @throws PersistentException - if service and dao layers produce this exception */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        @SuppressWarnings("unchecked")
        List<MenuItem> menu = (List<MenuItem>)request.getSession(false).getAttribute("menu");
        return new Forward(menu.get(0).getUrl());
    }
}
