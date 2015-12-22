package com.gmail.mordress.lab4.action.administrator;


        import com.gmail.mordress.lab4.action.Action;
        import com.gmail.mordress.lab4.domain.HorseRace;
        import com.gmail.mordress.lab4.exceptions.PersistentException;
        import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;
        import com.gmail.mordress.lab4.utils.DateFormatConverter;
        import org.apache.log4j.Logger;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.Date;

public class HorseRaceResultSaveAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(HorseRaceResultSaveAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/races/list.html");

        String parameter1 = request.getParameter("horseRaceId");
        String parameter2 = request.getParameter("newRank");
        String parameter3 = request.getParameter("newTime");
        String parameter4 = request.getParameter("newTimeSeconds");
        try {
            HorseRaceService service = factory.getService(HorseRaceService.class);
            HorseRace horseRace = service.findById(Integer.parseInt(parameter1));
            horseRace.setResultRank(Integer.parseInt(parameter2));
            Date newDate = DateFormatConverter.stringToDate(parameter3, parameter4);
            if (horseRace.getRace().getRaceDate().getTime() > newDate.getTime()) {
                forward.getAttributes().put("message", "Неправильное время финиша, результат не сохранен.");
                throw new PersistentException();
            }
            horseRace.setResultTime(newDate);
            service.save(horseRace);
        } catch (NumberFormatException e) {
            logger.warn("Can not update horserace result with new values: " + parameter2 + " " + parameter3 + " "+ parameter4);
        }

        return forward;
    }
}
