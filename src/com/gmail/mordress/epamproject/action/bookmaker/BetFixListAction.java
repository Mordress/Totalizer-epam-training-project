package com.gmail.mordress.epamproject.action.bookmaker;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Bet;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.BetService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BetFixListAction extends BookmakerAction {

    private static Logger logger = Logger.getLogger(BetFixListAction.class);

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
