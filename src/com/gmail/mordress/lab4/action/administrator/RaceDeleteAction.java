package com.gmail.mordress.lab4.action.administrator;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.ifaces.RaceService;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RaceDeleteAction extends AdministratorAction {

    private static Logger logger = Logger.getLogger(RaceDeleteAction.class);

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        Forward forward = new Forward("/races/list.html");
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            RaceService service = factory.getService(RaceService.class);
            service.delete(id);
            logger.info("Race with id= " + id + " was deleted by administrator");
            forward.getAttributes().put("message", "Забег успешно удален");
        } catch (PersistentException | NullPointerException| NumberFormatException e) {
            logger.info("Can not delete race with id= " + request.getParameter("id"));
            forward.getAttributes().put("message", "Невозможно удалить такой забег");
        }
        return forward;
    }
}
