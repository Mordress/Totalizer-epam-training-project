package com.gmail.mordress.epamproject.action.bookmaker;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Bet;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.BetService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Forming no-processed by bookmaker list of user's bets.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class BetFixListAction extends BookmakerAction {

    private static Logger logger = Logger.getLogger(BetFixListAction.class);

    /** Forming no-processed by bookmaker list of user's bets, and show it to bookmaker.
     * @param request incapsulating of HTTP request.
     * @param response incapsulating of HTTP response.
     * @return {@code null}
     * @throws PersistentException - if service and dao layers produce this exception. */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        BetService betService = factory.getService(BetService.class);
        List<Bet> notFixedBets = betService.findNotFixedBets();
        if (notFixedBets != null) {
            request.setAttribute("nofixbets", notFixedBets);
        }
        return null;
    }
}
