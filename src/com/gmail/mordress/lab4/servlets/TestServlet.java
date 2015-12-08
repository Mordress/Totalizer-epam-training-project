package com.gmail.mordress.lab4.servlets;

import com.gmail.mordress.lab4.dao.implementation.BreedDaoImpl;
import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.implementation.HorseDaoImpl;
import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.dao.interfaces.HorseDao;
import com.gmail.mordress.lab4.dao.pool.ConnectionPool;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.exceptions.ServiceException;
import com.gmail.mordress.lab4.services.implementations.HorseServiceImpl;
import com.gmail.mordress.lab4.services.implementations.ServiceFactoryImpl;
import com.gmail.mordress.lab4.services.interfaces.HorseService;
import com.gmail.mordress.lab4.services.interfaces.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TestServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(TestServlet.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        logger.debug("it's work!");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
