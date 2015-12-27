package com.gmail.mordress.lab4.action.user;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.entities.Horse;
import com.gmail.mordress.lab4.entities.Race;
import com.gmail.mordress.lab4.entities.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.ifaces.HorseService;
import com.gmail.mordress.lab4.services.ifaces.RaceService;
import com.gmail.mordress.lab4.services.ifaces.UserService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BetsCreateAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetsCreateAction.class);

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
