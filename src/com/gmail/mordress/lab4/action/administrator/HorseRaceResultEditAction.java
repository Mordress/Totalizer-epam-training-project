package com.gmail.mordress.lab4.action.administrator;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HorseRaceResultEditAction extends AdministratorAction {

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        /*try {
            Integer id = (Integer) request.getAttribute("id");
            if (id == null) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            HorseRaceService service = factory.getService(HorseRaceService.class);
            HorseRace horseRace = service.read(id);
            if (horseRace != null) {
                request.setAttribute("horseRace", horseRace);
            }
        } catch ()*/
        //TODO

        return null;
    }


}
