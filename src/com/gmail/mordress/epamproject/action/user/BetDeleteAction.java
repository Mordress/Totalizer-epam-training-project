package com.gmail.mordress.epamproject.action.user;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.BetService;
import com.gmail.mordress.epamproject.services.ifaces.UserService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class BetDeleteAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetDeleteAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/bets/list.html");
        UserService userService = factory.getService(UserService.class);
        User currentUser = (User)request.getSession(false).getAttribute("authorizedUser");
        try {
            Integer betId = Integer.parseInt(request.getParameter("id"));
            BigDecimal cashReturn = new BigDecimal(request.getParameter("betAmount"));
            BigDecimal newUserCash = cashReturn.add(userService.findById(currentUser.getId()).getCashAmount());
            BetService betService = factory.getService(BetService.class);
            betService.delete(betId);
            userService.updateUserCash(currentUser.getId(), newUserCash);
            logger.info("User " + currentUser.getLogin() + " deleted his bet with id = " + betId);
        } catch (PersistentException | NumberFormatException e ) {
            logger.error("Can not delete bet with id = " + request.getParameter("id"));
        }
        return forward;
    }
}
