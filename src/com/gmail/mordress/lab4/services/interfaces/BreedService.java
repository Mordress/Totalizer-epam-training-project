package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface BreedService extends Service {

    public Breed findByName(String name) throws PersistentException;

    public List<Breed> getAllBreeds() throws PersistentException;

    public void save(Breed breed) throws PersistentException;

    public void delete(Integer id) throws PersistentException;


}
