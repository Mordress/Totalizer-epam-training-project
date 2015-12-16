package com.gmail.mordress.lab4.action.user;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BetService;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;
import com.gmail.mordress.lab4.services.interfaces.RaceService;
import com.gmail.mordress.lab4.services.interfaces.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BetsListAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetsListAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        UserService userService = factory.getService(UserService.class);
        User currentUser = (User)request.getSession(false).getAttribute("authorizedUser");
        BetService betService = factory.getService(BetService.class);
        List<Bet> thisUserBets = betService.findAllBetsByUser(currentUser);
        request.setAttribute("bets", thisUserBets);
        return null;
    }

}
