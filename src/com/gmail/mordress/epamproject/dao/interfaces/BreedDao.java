package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

/**
 * Provides additional operations for breed-interaction with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface BreedDao extends Dao<Breed> {

    /** Returns breed instance found by name.
     * @param name - breed's name.
     * @return Breed instance.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public Breed findByName(String name) throws PersistentException;

    /** Returns all possible breeds.
     * @return List of Breeds.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public List<Breed> getAllBreeds() throws PersistentException;
}
