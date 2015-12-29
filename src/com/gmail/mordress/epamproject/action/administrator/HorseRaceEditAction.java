package com.gmail.mordress.epamproject.action.administrator;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseRaceService;
import com.gmail.mordress.epamproject.services.ifaces.RaceService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Process input data from administrator about horseRaces for some race.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseRaceEditAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(HorseRaceEditAction.class);

    /** Forming horseRaces for race, chosen by administrator.
     * @param request incapsulating of HTTP request
     * @param response incapsulating of HTTP response
     * @return forward to login page if registration was successful, and forward to registration page, if registration
     * failed.
     * @throws PersistentException - if service and dao layers produce this exception */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            Integer id = (Integer) request.getAttribute("id");
            if (id == null) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            RaceService service = factory.getService(RaceService.class);
            Race race = service.findById(id);
            if (race != null) {
                request.setAttribute("race", race);
            }
            HorseRaceService horseRaceService = factory.getService(HorseRaceService.class);
            List<HorseRace> horseRaces = horseRaceService.findByRace(race);
            if (horseRaces != null) {
                request.setAttribute("horseRaces", horseRaces);
            }
        } catch (NumberFormatException e) {}
        return null;
    }
}
