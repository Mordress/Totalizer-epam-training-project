package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.exceptions.PersistentException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Incapsulate contorls for command, request and response for next servlet or/and jsp.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface ActionManager {

    Action.Forward execute(Action action, HttpServletRequest request, HttpServletResponse response) throws PersistentException;

    void close();
}
