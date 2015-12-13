package com.gmail.mordress.lab4.action.administrator;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.domain.Role;

public abstract class AdministratorAction extends Action{
    public AdministratorAction() {
        getAllowRoles().add(Role.ADMINISTRATOR);
    }
}
