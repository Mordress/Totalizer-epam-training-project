package com.gmail.mordress.epamproject.action.user;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Role;

/**
 * Provides basic operation(action) for user.
 * @author Alexey Kardychko
 * @version 1.0
 */
public abstract class UserAction extends Action {

    public UserAction() {
        getAllowRoles().add(Role.USER);
    }
}
