package com.gmail.mordress.epamproject.entities;

/**
 * Class-Entity, describes user's roles. There are 3 possible roles:
 * <b>user</b>, <b>bookmaker</b>, <b>administrator</b>.
 * @author Alexey Kardychko
 * @version 1.0
 */
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
