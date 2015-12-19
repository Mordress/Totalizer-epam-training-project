package com.gmail.mordress.lab4.action.bookmaker;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.action.user.BetsListAction;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BetService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public class BetsFixedAction extends BookmakerAction {

    private static Logger logger = Logger.getLogger(BetsListAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {

        try {
            String isWinner = request.getParameter("iswinner");
            Integer betId = Integer.parseInt(request.getParameter("betId"));
            BigDecimal winAmount = new BigDecimal(request.getParameter("winamount"));

            BetService betService = factory.getService(BetService.class);
            Bet bet = betService.read(betId);

            System.out.println();
        } catch (NumberFormatException e) {
            logger.error("Can not parse input data from bookmaker");
        }
        //todo forward
        return null;
    }
}
