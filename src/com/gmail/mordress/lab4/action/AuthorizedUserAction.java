package com.gmail.mordress.lab4.action;

import com.gmail.mordress.lab4.domain.Role;

import java.util.Arrays;

public abstract class AuthorizedUserAction extends Action {

    public AuthorizedUserAction() {
        getAllowRoles().addAll(Arrays.asList(Role.values()));
    }
}
