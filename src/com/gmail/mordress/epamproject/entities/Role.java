package com.gmail.mordress.epamproject.entities;

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

    public static Role getById(Integer id) {
        if (id >= 0 && id <= 2) {
            return Role.values()[id];
        } else {
            return null;
        }
    }
}
