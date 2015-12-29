package com.gmail.mordress.epamproject.action.user;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Bet;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.BetService;
import com.gmail.mordress.epamproject.services.ifaces.UserService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Forming data to show unprocessed by bookmaker user's bets.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class BetsListAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetsListAction.class);

    /** Forming data about user's cash, and show compete and not complete bets for user.
     * @param request incapsulating of HTTP request.
     * @param response incapsulating of HTTP response.
     * @return null.
     * @throws PersistentException - if service and dao layers produce this exception. */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        UserService userService = factory.getService(UserService.class);
        User currentUser = (User)request.getSession(false).getAttribute("authorizedUser");
        request.setAttribute("cash", userService.findById(currentUser.getId()).getCashAmount());

        BetService betService = factory.getService(BetService.class);
        List<Bet> thisUserBets = new ArrayList<>();
        thisUserBets = betService.findAllBetsByUser(currentUser);
        if (!thisUserBets.isEmpty()) {
            List<Bet> thisUserPassedBets = new ArrayList<>();
            List<Bet> thisUserNotPassedBets = new ArrayList<>();
            Date now = new Date();
            for (Bet bet : thisUserBets) {
                if (bet.getHorseRace().getRace().getRaceDate().getTime() <= now.getTime()) {
                    thisUserPassedBets.add(bet);
                } else {
                    thisUserNotPassedBets.add(bet);
                }
            }
            request.setAttribute("passedBets", thisUserPassedBets);
            request.setAttribute("futureBets", thisUserNotPassedBets);
        }
        return null;
    }
}
