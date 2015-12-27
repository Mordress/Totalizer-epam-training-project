package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

public interface BreedService extends Service {

    public Breed findByName(String name) throws PersistentException;

    public List<Breed> getAllBreeds() throws PersistentException;

    public void save(Breed breed) throws PersistentException;

    public void delete(Integer id) throws PersistentException;


}
