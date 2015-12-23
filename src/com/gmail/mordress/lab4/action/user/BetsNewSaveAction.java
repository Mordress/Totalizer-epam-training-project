package com.gmail.mordress.lab4.action.user;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.*;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.*;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;

public class BetsNewSaveAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetsNewSaveAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/bets/list.html");
        User currentUser = (User)request.getSession(false).getAttribute("authorizedUser");
        try {
            Integer raceId = Integer.parseInt(request.getParameter("chosenRaceId"));
            Integer horseId = Integer.parseInt(request.getParameter("chosenHorseId"));
            String betAmount = request.getParameter("betAmount");
            Integer rank = Integer.parseInt(request.getParameter("rank"));

            /*Создаем по частям новую ставку*/
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

            /*Если всё прошло хорошо и не был выброшен никакой эксепшн, то вычитаем размер ставки из баланса пользователя */
            UserService userService = factory.getService(UserService.class);
            BigDecimal newCashAmount = currentUser.getCashAmount();
            newCashAmount = newCashAmount.subtract(new BigDecimal(betAmount));
            currentUser.setCashAmount(newCashAmount);
            userService.updateUserCash(currentUser.getId(), currentUser.getCashAmount());
            forward.getAttributes().put("message", "Ваша ставка успешно создана");

        } catch (NumberFormatException | PersistentException e) {
            logger.error("User " + currentUser.getLogin() + " can't create new bet");
            forward.getAttributes().put("message", "Не удалось создать ставку");
            //написать в mesage, что он не может сделать ставку
            //откатить деньги назад
            //ловить эксепшн, есои что- то пошло не так и не создавать ставку
        }

        return forward;
    }


}
