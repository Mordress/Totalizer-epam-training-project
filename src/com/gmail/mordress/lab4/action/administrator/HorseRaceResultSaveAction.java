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

    private static Logger logger = Logger.getLogger(HorseRaceResultSaveAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/horseraces/edit.html");

        String horseRaceId = request.getParameter("horseRaceId");
        String newRank = request.getParameter("newRank");
        String newTimeHours = request.getParameter("newTimeHours");
        String newTimeMinutes = request.getParameter("newTimeMinutes");
        String newTimeSeconds = request.getParameter("newTimeSeconds");
        //TODO VALIDATION FOR DUPLICATES RANKS
        try {
            HorseRaceService service = factory.getService(HorseRaceService.class);
            HorseRace horseRace = service.findById(Integer.parseInt(horseRaceId));
            horseRace.setResultRank(Integer.parseInt(newRank));
            Integer hours = Integer.parseInt(newTimeHours);
            Integer mins = Integer.parseInt(newTimeMinutes);
            Integer secs = Integer.parseInt(newTimeSeconds);
            Date resultTime = DateFormatConverter.DateFromUI(horseRace.getRace().getRaceDate(), hours, mins, secs);
            horseRace.setResultTime(resultTime);
            service.save(horseRace);
            forward.getAttributes().put("id", horseRace.getRace().getId());
        } catch (NumberFormatException e) {
            logger.warn(new StringBuilder("Can not update horse-race result, because administartor use wrong input")
            .append(" New horse rank:").append(newRank).append(" resault hours: ").append(newTimeHours)
            .append(" resault minutes:").append(newTimeMinutes).append(" resault secs:").append(newTimeSeconds)
            .toString());
        }
        return forward;
    }
}
