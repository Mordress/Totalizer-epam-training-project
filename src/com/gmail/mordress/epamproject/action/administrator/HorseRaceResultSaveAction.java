package com.gmail.mordress.epamproject.action.administrator;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseRaceService;
import com.gmail.mordress.epamproject.services.ifaces.RaceService;
import com.gmail.mordress.epamproject.utils.DateFormatConverter;
import com.gmail.mordress.epamproject.validators.HorseRaceValidator;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Process input data from administrator about horseRaces for save changes.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseRaceResultSaveAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(HorseRaceResultSaveAction.class);

    /** Saving horseRaces's changes, if they valid, using service layer.
     * @param request incapsulating of HTTP request.
     * @param response incapsulating of HTTP response.
     * @return forward to page for editing horseRaces.
     * @throws PersistentException - if service and dao layers produce this exception. */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/horseraces/edit.html");

        String horseRaceId = request.getParameter("horseRaceId");
        String newRank = request.getParameter("newRank");
        String newTimeHours = request.getParameter("newTimeHours");
        String newTimeMinutes = request.getParameter("newTimeMinutes");
        String newTimeSeconds = request.getParameter("newTimeSeconds");
        try {
            HorseRaceService horseRaceService = factory.getService(HorseRaceService.class);
            HorseRace horseRace = horseRaceService.findById(Integer.parseInt(horseRaceId));
            forward.getAttributes().put("id", horseRace.getRace().getId());
            RaceService raceService = factory.getService(RaceService.class);
            Race race = raceService.findById(horseRace.getRace().getId());
            Integer rank = Integer.parseInt(newRank);
            HorseRaceValidator validator = HorseRaceValidator.getInstance();
            if (validator.isRankPossible(horseRaceService.findByRace(race), rank)) {
                horseRace.setResultRank(rank);
                Integer hours = Integer.parseInt(newTimeHours);
                Integer mins = Integer.parseInt(newTimeMinutes);
                Integer secs = Integer.parseInt(newTimeSeconds);
                Date resultTime = DateFormatConverter.DateFromUI(horseRace.getRace().getRaceDate(), hours, mins, secs);
                horseRace.setResultTime(resultTime);
                horseRaceService.save(horseRace);
                forward.getAttributes().put("id", horseRace.getRace().getId());
            } else {
                forward.getAttributes().put("message", "Невозможно зафиксировать результат: дублирование места.");
                return forward;
            }
        } catch (NumberFormatException e) {
            logger.error("Can not update horseRace result, because administrator use wrong data");
        }
        return forward;
    }
}
