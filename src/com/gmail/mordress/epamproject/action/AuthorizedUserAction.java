package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.Role;

import java.util.Arrays;

public abstract class AuthorizedUserAction extends Action {

    public AuthorizedUserAction() {
        getAllowRoles().addAll(Arrays.asList(Role.values()));
    }
}
