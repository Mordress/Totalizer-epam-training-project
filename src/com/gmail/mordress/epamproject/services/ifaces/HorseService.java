package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

/**
 * Provides operations for horse-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface HorseService extends Service {

    /** Returns horse instance found by name.
     * @param name - horse's name.
     * @return Horse instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public Horse findByName(String name) throws PersistentException;

    /** Returns horse instance found by id.
     * @param id - horse's id.
     * @return Horse instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public Horse findHorseById(Integer id) throws PersistentException;

    /** Returns all horses with same breed.
     * @param breed - Some breed instance.
     * @return List of Horses.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException;

    /** Returns all possible horses.
     * @return List of Horses.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public List<Horse> getAllHorses() throws PersistentException;
}
