package com.gmail.mordress.epamproject.controller;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.action.ActionManager;
import com.gmail.mordress.epamproject.action.ActionManagerFactory;
import com.gmail.mordress.epamproject.action.ActionManagerFactoryImpl;
import com.gmail.mordress.epamproject.dao.mysql.DaoFactoryImpl;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.impls.ServiceFactoryImpl;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TimeZone;

public class DispatcherServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(DispatcherServlet.class);

    @Override
    public void init() throws ServletException {
        Logger root = Logger.getRootLogger();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Minsk"));
    }

    public ActionManagerFactory getFactory() throws PersistentException {
        return new ActionManagerFactoryImpl(new ServiceFactoryImpl(new DaoFactoryImpl()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Action action = (Action)request.getAttribute("action");
        try {
            ActionManager actionManager = getFactory().getManager();
            Action.Forward forward = actionManager.execute(action, request, response);
            actionManager.close();
            String requestedUri = request.getRequestURI();
            if (forward != null && forward.isRedirect()) {
                String redirectedUri = request.getContextPath() + forward.getForward();
                logger.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
                response.sendRedirect(redirectedUri);
            } else {
                String jspPage;
                if (forward != null) {
                    jspPage = forward.getForward();
                } else {
                    jspPage = action.getName() + ".jsp";
                }
                jspPage = "/WEB-INF/jsp" + jspPage;
                logger.debug(String.format("Request for URI \"%s\" is forwarded to JSP \"%s\"", requestedUri, jspPage));
                getServletContext().getRequestDispatcher(jspPage).forward(request, response);
            }
        } catch(PersistentException e) {
            logger.error("It is impossible to process request", e);
            request.setAttribute("error", "Ошибка обработки данных");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
