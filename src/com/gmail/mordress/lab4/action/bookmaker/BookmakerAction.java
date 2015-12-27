package com.gmail.mordress.lab4.action.bookmaker;

import com.gmail.mordress.lab4.action.Action;
import com.gmail.mordress.lab4.entities.Role;

public abstract class BookmakerAction extends Action {

    public BookmakerAction() {
        getAllowRoles().add(Role.BOOKMAKER);
    }
}
