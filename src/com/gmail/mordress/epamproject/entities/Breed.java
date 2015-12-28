package com.gmail.mordress.epamproject.entities;

/**
 * Class-Entity, describes horse's breed.
 * @author Alexey Kardychko
 * @version 1.0
 */
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
        return new StringBuilder("Breed:{")
                .append("BreedId = ").append(this.getId())
                .append(", breedName = ").append(name)
                .append("}")
                .toString();
    }
}
