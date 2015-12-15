package com.gmail.mordress.lab4.action.administrator;


import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HorseRaceResultSaveAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(HorseRaceEditAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/horseraces/edit.html");
        //TODO
       /* HorseRace horseRace = new HorseRace();
        horseRace.set
        HorseRaceService service = factory.getService(HorseRaceService.class);
        service.save()
        */
        forward.getAttributes().put("id", request.getAttribute("id"));
        forward.getAttributes().put("message", "Данные успешно сохранены");

        return forward;
    }
}
