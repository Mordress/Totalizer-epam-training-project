package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseService;

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
