package com.gmail.mordress.lab4.action.administrator;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.RaceService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RaceListAction extends AdministratorAction{

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        RaceService service = factory.getService(RaceService.class);
        List<Race> futureRaces = service.getFutureRaces();
        List<Race> passedRaces = service.getPassedRaces();
        request.setAttribute("futureRaces", futureRaces);
        request.setAttribute("passedRaces", passedRaces);
        return null;
    }
}
