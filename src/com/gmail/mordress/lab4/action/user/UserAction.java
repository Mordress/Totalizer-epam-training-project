package com.gmail.mordress.lab4.action.user;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.entities.Role;

public abstract class UserAction extends Action {

    public UserAction() {
        getAllowRoles().add(Role.USER);
    }
}
