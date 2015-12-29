package com.gmail.mordress.epamproject.action.administrator;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.RaceService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Forming list of future and passed races for show to administrator.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class RaceListAction extends AdministratorAction {

    /** Create 2 lists with races: passed races and future races for show to administrator.
     * @param request incapsulating of HTTP request.
     * @param response incapsulating of HTTP response.
     * @return {@code null}
     * @throws PersistentException - if service and dao layers produce this exception. */
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
