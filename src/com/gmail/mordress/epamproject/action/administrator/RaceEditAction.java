package com.gmail.mordress.epamproject.action.administrator;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RaceEditAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(RaceEditAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        return null;
    }
}
