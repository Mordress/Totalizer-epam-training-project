package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

/**
 * Provides operations for race-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface RaceService extends Service {

    /** Returns all currently passed race instances.
     * @return List of HorseRace instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public List<Race> getPassedRaces() throws PersistentException;

    /** Returns all currently not passed race instances.
     * @return List of HorseRace instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public List<Race> getFutureRaces() throws PersistentException;

    /** Returns race instance found by id.
     * @param id - race's id.
     * @return race instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public Race findById(Integer id) throws PersistentException;

    /** Saves changes to race, or create new race.
     * @param race - changed/new race.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void save(Race race) throws PersistentException;

    /** Deletes race by id.
     * @param id - race's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void delete(Integer id) throws PersistentException;
}
