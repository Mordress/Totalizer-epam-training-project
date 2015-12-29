package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

/**
 * Provides operations for breed-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface BreedService extends Service {

    /** Returns founded by name breed instance.
     * @param name - breed's name.
     * @return Breed instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public Breed findByName(String name) throws PersistentException;

    /** Returns all possible breeds.
     * @return List of Breeds.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public List<Breed> getAllBreeds() throws PersistentException;

    /** Saves changes to breed, or create new breed.
     * @param breed - changed/new breed.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void save(Breed breed) throws PersistentException;

    /** Deletes breed by id.
     * @param id - breed's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void delete(Integer id) throws PersistentException;
}
