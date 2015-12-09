package com.gmail.mordress.lab4.servlets;

import com.gmail.mordress.lab4.dao.pool.ConnectionPool;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(TestServlet.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        logger.debug("it's work!");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
