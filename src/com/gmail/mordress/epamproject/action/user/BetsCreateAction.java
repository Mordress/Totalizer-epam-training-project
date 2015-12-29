package com.gmail.mordress.epamproject.action.user;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseService;
import com.gmail.mordress.epamproject.services.ifaces.RaceService;
import com.gmail.mordress.epamproject.services.ifaces.UserService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Forming data needs to create user's bets.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class BetsCreateAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetsCreateAction.class);

    /** Forming data about user's cash, available horses and available races to create user's bets.
     * @param request incapsulating of HTTP request.
     * @param response incapsulating of HTTP response.
     * @return null.
     * @throws PersistentException - if service and dao layers produce this exception. */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        UserService userService = factory.getService(UserService.class);
        User currentUser = (User)request.getSession(false).getAttribute("authorizedUser");
        request.setAttribute("cash", userService.findById(currentUser.getId()).getCashAmount());

        RaceService raceService = factory.getService(RaceService.class);
        List<Race> futureRaces = raceService.getFutureRaces();
        request.setAttribute("futureRaces", futureRaces);

        HorseService horseService = factory.getService(HorseService.class);
        List<Horse> allHorses = horseService.getAllHorses();
        request.setAttribute("allHorses", allHorses);
        request.setAttribute("horseCount", allHorses.size());
        return null;
    }
}
