package com.gmail.mordress.lab4.controller;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.action.ActionManager;
import com.gmail.mordress.lab4.action.ActionManagerFactory;
import com.gmail.mordress.lab4.action.ActionManagerFactoryImpl;
import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.implementations.ServiceFactoryImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(DispatcherServlet.class);

    @Override
    public void init() throws ServletException {
            Logger root = Logger.getRootLogger();
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

    /* В этом методе мы перенаправляем запрос хxx.html на xxx.jsp, сохраняя данные в сессию(откуда мы пришли)*/
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*Читаем из реквеста экшен*/
        Action action = (Action)request.getAttribute("action");
        try {
            /*Создаем экшен менеджер, получая его из фабрики эшен-менеджеров*/
            ActionManager actionManager = getFactory().getManager();
            /* Передаем выполнение действия, с параметрами экшен, запрос, ответ экшен-менеджеру, который записывает в сессию с какой страницы мы пришли */
            Action.Forward forward = actionManager.execute(action, request, response);
            actionManager.close();
            /* Создаем строку запрашиваемого URI*/
            String requestedUri = request.getRequestURI();
            /*  */
            if(forward != null && forward.isRedirect()) {
                /* Создаем строку URI страницы с которой мы пришли */
                String redirectedUri = request.getContextPath() + forward.getForward();
                logger.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
                /* Записываем в ответ страницу с которой мы пришли */
                response.sendRedirect(redirectedUri);
            } else {
                /* Если мы пришли не с другой страницы, то */
                String jspPage;
                if(forward != null) {
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
