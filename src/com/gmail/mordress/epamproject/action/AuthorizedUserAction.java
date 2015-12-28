package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.Role;

import java.util.Arrays;

/**
 * Incapsulate permitted actions for administrator.
 * @author Alexey Kardychko
 * @version 1.0
 */
public abstract class AuthorizedUserAction extends Action {

    public AuthorizedUserAction() {
        getAllowRoles().addAll(Arrays.asList(Role.values()));
    }
}
