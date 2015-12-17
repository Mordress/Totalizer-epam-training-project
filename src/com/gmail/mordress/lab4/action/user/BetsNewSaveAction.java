package com.gmail.mordress.lab4.action.user;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;
import com.gmail.mordress.lab4.services.interfaces.HorseService;
import com.gmail.mordress.lab4.services.interfaces.RaceService;
import com.gmail.mordress.lab4.services.interfaces.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class BetsNewSaveAction extends UserAction {

    private static Logger logger = Logger.getLogger(BetsListAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        //todo forward
        try {
            Integer raceId = Integer.parseInt(request.getParameter("chosenRaceId"));
            Integer horseId = Integer.parseInt(request.getParameter("chosenHorseId"));
            String betAmount = request.getParameter("betAmount");
            Integer rank = Integer.parseInt(request.getParameter("rank"));

            UserService userService = factory.getService(UserService.class);
            User currentUser = (User)request.getSession(false).getAttribute("authorizedUser");
            /* Вычитаем размер ставки из баланса пользователя */
            BigDecimal newCashAmount = currentUser.getCashAmount();
            newCashAmount = newCashAmount.subtract(new BigDecimal(betAmount));
            currentUser.setCashAmount(newCashAmount);
            userService.updateUserCash(currentUser.getId(), currentUser.getCashAmount());

            /*Создаем по частям новую ставку*/
            HorseService horseService = factory.getService(HorseService.class);
            Horse horse = horseService.findHorseById(horseId);
            RaceService raceService = factory.getService(RaceService.class);
            Race race = raceService.findById(raceId);
            System.out.println();

            HorseRaceService horseRaceService = factory.getService(HorseRaceService.class);
            HorseRace horseRace = horseRaceService.findByRaceAndHorse(horseId, raceId);
            //Создали готовый хорс-рейс, надо создать бет и запихнуть в него этот хорс рейс и остальное

        } catch (NumberFormatException e) {

        }

        return null;
    }


}
