package com.gmail.mordress.epamproject.action.administrator;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseRaceService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Process input data from administrator about horseRaces for some race.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseRaceResultEditAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(HorseRaceResultEditAction.class);

    /** Editing horseRaces using service layer for race, chosen by administrator.
     * @param request incapsulating of HTTP request.
     * @param response incapsulating of HTTP response.
     * @return {@code null}.
     * @throws PersistentException - if service and dao layers produce this exception */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        try {
            Integer id = (Integer) request.getAttribute("id");
            if (id == null) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            HorseRaceService service = factory.getService(HorseRaceService.class);
            HorseRace horseRace = service.findById(id);
            if (horseRace != null) {
                request.setAttribute("horseRace", horseRace);
            }
        } catch (NumberFormatException e) {
            logger.error("Can not parse horseRace id = " + request.getAttribute("id"));
        }
        return null;
    }
}
