package com.gmail.mordress.lab4.action;

import com.gmail.mordress.lab4.exceptions.PersistentException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionManager {

    Action.Forward execute(Action action, HttpServletRequest request, HttpServletResponse response) throws PersistentException;

    void close();
}
