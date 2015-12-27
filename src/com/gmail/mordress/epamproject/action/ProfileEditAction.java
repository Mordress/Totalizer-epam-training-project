package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.exceptions.PersistentException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileEditAction extends AuthorizedUserAction {

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        return null;
    }
}
