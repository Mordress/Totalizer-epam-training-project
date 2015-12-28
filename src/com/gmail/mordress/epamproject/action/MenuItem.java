package com.gmail.mordress.epamproject.action;

/**
 * Represent available pages for user.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class MenuItem {

    private String url;

    private String name;

    public MenuItem(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
