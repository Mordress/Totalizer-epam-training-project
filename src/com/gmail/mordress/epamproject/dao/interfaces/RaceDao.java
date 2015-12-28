package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

/**
 * Provides additional operations race-interaction with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface RaceDao extends Dao<Race> {

    /** Returns all currently passed race instances.
     * @return List of HorseRace instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public List<Race> getPassedRaces() throws PersistentException;

    /** Returns all currently not passed race instances.
     * @return List of HorseRace instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public List<Race> getFutureRaces() throws PersistentException;
}
