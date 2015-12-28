package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

/**
 * Provides additional operations for horse-interaction with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface HorseDao  extends Dao<Horse> {

    /** Returns horse instance found by name.
     * @param name - horse's name.
     * @return Horse instance.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public Horse findByName(String name) throws PersistentException;

    /** Returns all horses with same breed.
     * @param breed - Some breed instance.
     * @return List of Horses.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException;

    /** Returns all possible horses.
     * @return List of Horses.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public List<Horse> getAllHorses() throws PersistentException;
}
