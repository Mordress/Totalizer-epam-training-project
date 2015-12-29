package com.gmail.mordress.epamproject.controller;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.action.MainAction;
import com.gmail.mordress.epamproject.entities.Role;
import com.gmail.mordress.epamproject.entities.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * Checks user's rights to forward him to appropriate servlet/jsp.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class SecurityFilter implements Filter {

    private static Logger logger = Logger.getLogger(SecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    /** Checks user's rights to forward him to appropriate servlet/jsp.
     * @param request servlet request.
     * @param response servlet response.
     * @param chain servlet filter chain
     * @throws IOException - if process requested URI throws this exception.
     * @throws ServletException - if servlet can not do this operation correctly. */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            Action action = (Action)httpRequest.getAttribute("action");
            Set<Role> allowRoles = action.getAllowRoles();
            String userName = "unauthorized user";
            HttpSession session = httpRequest.getSession(false);
            User user = null;
            if (session != null) {
                user = (User)session.getAttribute("authorizedUser");
                action.setAuthorizedUser(user);
                String errorMessage = (String)session.getAttribute("SecurityFilterMessage");
                if (errorMessage != null) {
                    httpRequest.setAttribute("message", errorMessage);
                    session.removeAttribute("SecurityFilterMessage");
                }
            }
            boolean canExecute = allowRoles == null || allowRoles.isEmpty();
            if (user != null) {
                userName = "\"" + user.getLogin() + "\" user";
                canExecute = canExecute || allowRoles.contains(user.getRole());
            }
            if (canExecute) {
                chain.doFilter(request, response);
            } else {
                logger.info(String.format("Trying of %s access to forbidden resource \"%s\"", userName, action.getName()));
                if(session != null && action.getClass() != MainAction.class) {
                    session.setAttribute("SecurityFilterMessage", "Доступ запрещён");
                }
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
            }
        } else {
            logger.error("It is impossible to use HTTP filter");
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {}
}
