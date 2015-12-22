package com.gmail.mordress.lab4.action.bookmaker;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.action.user.BetsListAction;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BetService;
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
