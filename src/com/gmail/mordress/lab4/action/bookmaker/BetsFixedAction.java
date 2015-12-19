package com.gmail.mordress.lab4.action.bookmaker;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.action.user.BetsListAction;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BetService;
import com.gmail.mordress.lab4.services.interfaces.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public class BetsFixedAction extends BookmakerAction {

    private static Logger logger = Logger.getLogger(BetsListAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/bets/fix.html");
        try {
            String isWinner = request.getParameter("iswinner");
            Integer betId = Integer.parseInt(request.getParameter("betId"));
            BigDecimal winAmount = new BigDecimal(request.getParameter("winamount"));

            BetService betService = factory.getService(BetService.class);
            Bet bet = betService.read(betId);
            bet.setWinAmount(winAmount);
            if (isWinner.equals("yes")) {
                bet.setIsWinner(true);
            } else if (isWinner.equals("no")) {
                bet.setIsWinner(false);
            }
            betService.save(bet);
            /* Закидываем деньни юзеру на счет*/
            if (bet.getIsWinner()) {
                UserService userService = factory.getService(UserService.class);
                User user = userService.findById(bet.getUser().getId());
                BigDecimal newCashAmount = user.getCashAmount().add(winAmount);
                userService.updateUserCash(user.getId(), newCashAmount);
            }
            forward.getAttributes().put("message", "Ставка успешно обработана");
        } catch (NumberFormatException e) {
            forward.getAttributes().put("message", "Невозможно обработать ставку с такими параметрами");
            logger.error("Can not parse input data from bookmaker for update bet");
        }
        return forward;
    }
}
