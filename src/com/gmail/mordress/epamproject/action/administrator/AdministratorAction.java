package com.gmail.mordress.epamproject.action.administrator;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Role;

/**
 * Provides basic operation(action) for administrator.
 * @author Alexey Kardychko
 * @version 1.0
 */
public abstract class AdministratorAction extends Action {

    public AdministratorAction() {
        getAllowRoles().add(Role.ADMINISTRATOR);
    }
}
