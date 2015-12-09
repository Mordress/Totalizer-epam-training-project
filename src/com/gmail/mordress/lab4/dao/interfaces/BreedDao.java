package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface BreedDao extends Dao<Breed> {

    public Breed findByName(String name) throws PersistentException;

    public List<Breed> getAllBreeds() throws PersistentException;
}
