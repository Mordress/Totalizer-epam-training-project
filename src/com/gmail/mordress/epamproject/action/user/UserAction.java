package com.gmail.mordress.epamproject.action.user;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Role;

public abstract class UserAction extends Action {

    public UserAction() {
        getAllowRoles().add(Role.USER);
    }
}
