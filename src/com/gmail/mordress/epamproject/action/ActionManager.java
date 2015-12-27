package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.exceptions.PersistentException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionManager {

    Action.Forward execute(Action action, HttpServletRequest request, HttpServletResponse response) throws PersistentException;

    void close();
}
