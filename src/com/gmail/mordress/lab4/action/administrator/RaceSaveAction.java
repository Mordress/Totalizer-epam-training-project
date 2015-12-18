package com.gmail.mordress.lab4.action.administrator;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;
import com.gmail.mordress.lab4.services.interfaces.HorseService;
import com.gmail.mordress.lab4.services.interfaces.RaceService;
import com.gmail.mordress.lab4.services.interfaces.ServiceFactory;
import com.gmail.mordress.lab4.utils.DateFormatConverter;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class RaceSaveAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(RaceSaveAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/races/list.html");
        try {
            Race race = new Race();
            String parameter = request.getParameter("date");
            if (parameter != null && !parameter.isEmpty()) {
                Date date = DateFormatConverter.stringToDate(parameter);
                if (date != null) {
                    race.setRaceDate(date);
                }

            }
            parameter = request.getParameter("distance");
            if (parameter != null && !parameter.isEmpty()) {
                race.setDistance(Integer.parseInt(parameter));
            }
            RaceService service = factory.getService(RaceService.class);
            service.save(race);
            /* Создаем для нового забега список результатов без результатов о_О*/
            HorseRaceService horseRaceService = factory.getService(HorseRaceService.class);
            HorseService horseService = factory.getService(HorseService.class);
            List<Horse> horses = horseService.getAllHorses();
            for (Horse horse : horses) {
                HorseRace hr = new HorseRace();
                hr.setRace(race);
                hr.setHorse(horse);
                horseRaceService.save(hr);
            }
            forward.getAttributes().put("message", "Новый забег успешно сохранен");
        } catch (NumberFormatException e) {
            logger.error("administrator had tried to create new race with wrong parameters");
            forward.getAttributes().put("message", "Невозможно создать такой забег");

        }
        return forward;
    }
}
