package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Process requred data for formation information about horses.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseListAction extends AuthorizedUserAction {

    /** Getting data from service layer about available horses and create request attributes for processing they in jsp.
     * @param request incapsulating of HTTP request
     * @param response incapsulating of HTTP response
     * @return null.
     * @throws PersistentException - if service and dao layers produce this exception */
    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        HorseService horseService = factory.getService(HorseService.class);
        List<Horse> allHorses = horseService.getAllHorses();
        request.setAttribute("allHorses", allHorses);
        return null;
    }
}
