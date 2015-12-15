package com.gmail.mordress.lab4.action.administrator;


import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;
import com.gmail.mordress.lab4.utils.DateFormatConverter;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class HorseRaceResultSaveAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(HorseRaceEditAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/races/list.html");
        HorseRaceService service = factory.getService(HorseRaceService.class);
        String parameter = request.getParameter("horseRaceId");
        HorseRace horseRace  = service.findById(Integer.parseInt(parameter));
        parameter = request.getParameter("newRank");
        horseRace.setResultRank(Integer.parseInt(parameter));
        parameter = request.getParameter("newTime");
        String paramter2 = request.getParameter("newTimeSeconds");
        Date newDate = DateFormatConverter.stringToDate(parameter, paramter2);
        horseRace.setResultTime(newDate);
        service.save(horseRace);
        //todo try


        return forward;
    }
}
