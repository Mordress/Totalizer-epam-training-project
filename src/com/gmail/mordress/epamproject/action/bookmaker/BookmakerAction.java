package com.gmail.mordress.epamproject.action.bookmaker;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Role;

public abstract class BookmakerAction extends Action {

    public BookmakerAction() {
        getAllowRoles().add(Role.BOOKMAKER);
    }
}
