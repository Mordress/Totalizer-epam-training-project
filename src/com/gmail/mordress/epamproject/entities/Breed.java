package com.gmail.mordress.epamproject.entities;

public class Breed extends Entity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "name='" + name + '\'' +
                '}';
    }
}
