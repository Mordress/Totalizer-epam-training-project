package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

public interface BreedDao extends Dao<Breed> {

    public Breed findByName(String name) throws PersistentException;

    public List<Breed> getAllBreeds() throws PersistentException;
}
