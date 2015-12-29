package com.gmail.mordress.epamproject.action.user;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.*;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.*;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Processes input data from user for create new bet.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class BetsNewSaveAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetsNewSaveAction.class);

    /** Creates new bet, updates user's cash after it. If bet can not be created, cash will be not updated.
     * @param request incapsulating of HTTP request.
     * @param response incapsulating of HTTP response.
     * @return forward to main page for user.
     * @throws PersistentException - if service and dao layers produce this exception. */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/bets/list.html");
        User currentUser = (User)request.getSession(false).getAttribute("authorizedUser");
        try {
            Integer raceId = Integer.parseInt(request.getParameter("chosenRaceId"));
            Integer horseId = Integer.parseInt(request.getParameter("chosenHorseId"));
            String betAmount = request.getParameter("betAmount");
            Integer rank = Integer.parseInt(request.getParameter("rank"));
            /* creating new bet from parts*/
            HorseService horseService = factory.getService(HorseService.class);
            Horse horse = horseService.findHorseById(horseId);
            RaceService raceService = factory.getService(RaceService.class);
            Race race = raceService.findById(raceId);
            HorseRaceService horseRaceService = factory.getService(HorseRaceService.class);
            HorseRace horseRace = horseRaceService.findByRaceAndHorse(horseId, raceId);
            BetService betService = factory.getService(BetService.class);
            Bet bet = new Bet();
            bet.setHorseRace(horseRace);
            bet.setResultRank(rank);
            bet.setBetAmount(new BigDecimal(betAmount));
            bet.setUser(currentUser);
            bet.setCreatedDate(new Date());
            betService.save(bet);
            /* if exception not be throwed, updating user cash */
            UserService userService = factory.getService(UserService.class);
            BigDecimal newCashAmount = currentUser.getCashAmount();
            newCashAmount = newCashAmount.subtract(new BigDecimal(betAmount));
            currentUser.setCashAmount(newCashAmount);
            userService.updateUserCash(currentUser.getId(), currentUser.getCashAmount());
            forward.getAttributes().put("message", "Ваша ставка успешно создана");
        } catch (NumberFormatException | PersistentException e) {
            logger.error("User " + currentUser.getLogin() + " can't create new bet");
            forward.getAttributes().put("message", "Не удалось создать ставку");
        }

        return forward;
    }


}
