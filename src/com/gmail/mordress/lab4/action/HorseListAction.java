package com.gmail.mordress.lab4.action;

import com.gmail.mordress.lab4.entities.Horse;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.ifaces.HorseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HorseListAction extends AuthorizedUserAction {

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        HorseService horseService = factory.getService(HorseService.class);
        List<Horse> allHorses = horseService.getAllHorses();
        request.setAttribute("allHorses", allHorses);
        return null;
    }
}
