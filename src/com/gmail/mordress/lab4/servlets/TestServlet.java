package com.gmail.mordress.lab4.servlets;

import com.gmail.mordress.lab4.dao.implementation.BreedDaoImpl;
import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.PersistentException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<h1> Hello from Test Servlet </h1>");
        pw.println("<h1> Привет </h1>");
        logger.debug("test");
        try {
            DaoFactory instance = new DaoFactoryImpl();
            BreedDaoImpl bdi = instance.createDao(BreedDao.class);
            List<Breed> breeds = bdi.getAllBreeds();
            for (Breed breed : breeds) {
                pw.println(breed.getName());
            }
        } catch (DaoException | PersistentException e) {
            logger.error("not working =(");
            e.printStackTrace();
        }
    }
}
