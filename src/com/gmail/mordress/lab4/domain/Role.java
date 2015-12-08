package com.gmail.mordress.lab4.domain;

public enum Role {

    USER("пользователь"),
    BOOKMAKER("букмекер"),
    ADMINISTRATOR("администратор");

    private String name;

    private Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static Role getByIdentity(Integer identity) {
        if (identity >= 0 && identity <= 2) {
            return Role.values()[identity];
        } else {
            return null;
        }
    }
}
