package com.gmail.mordress.lab4.action.administrator;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.RaceService;
import com.gmail.mordress.lab4.services.interfaces.ServiceFactory;
import com.gmail.mordress.lab4.utils.DateFormatConverter;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class RaceSaveAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(RaceSaveAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/races/list.html");
        try {
            Race race = new Race();
            String parameter = request.getParameter("date");
            if (parameter != null && !parameter.isEmpty()) {
                Date date = DateFormatConverter.stringToDate(parameter);
                if (date != null) {
                    race.setRaceDate(date);
                }

            }
            parameter = request.getParameter("distance");
            if (parameter != null && !parameter.isEmpty()) {
                race.setDistance(Integer.parseInt(parameter));
            }
            RaceService service = factory.getService(RaceService.class);
            service.save(race);
            logger.debug(race.toString());
        } catch (NumberFormatException e) {
            logger.debug("Can not parse input date or distance for race creation");

        }
        return forward;
    }
}
