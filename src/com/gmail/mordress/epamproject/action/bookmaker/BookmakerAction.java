package com.gmail.mordress.epamproject.action.bookmaker;

import com.gmail.mordress.epamproject.action.Action;
import com.gmail.mordress.epamproject.entities.Role;

/**
 * Provides basic operation(action) for bookmaker.
 * @author Alexey Kardychko
 * @version 1.0
 */
public abstract class BookmakerAction extends Action {

    public BookmakerAction() {
        getAllowRoles().add(Role.BOOKMAKER);
    }
}
