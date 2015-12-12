package com.gmail.mordress.lab4.action;

import com.gmail.mordress.lab4.exceptions.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileEditAction extends AuthorizedUserAction {

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        return null;
    }
}
