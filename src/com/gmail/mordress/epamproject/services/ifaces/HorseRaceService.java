package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

/**
 * Provides operations for horseRace-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface HorseRaceService extends Service {

    /** Returns all horseRace instances with same race.
     * @param race - Race.
     * @return List of HorseRace instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public List<HorseRace> findByRace(Race race) throws PersistentException;

    /** Returns horseRace instances by id.
     * @param id - horseRace's id.
     * @return horseRace instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public HorseRace findById(Integer id) throws PersistentException;

    /** Saves changes to horseRace, or create new horseRace.
     * @param horseRace - changed/new horseRace.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void save(HorseRace horseRace) throws PersistentException;

    /** Returns horseRace instance with same race and same horse.
     * @param horseId - Horse instance id.
     * @param raceId - Race instance id.
     * @return List of HorseRace instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public HorseRace findByRaceAndHorse(Integer horseId, Integer raceId) throws PersistentException;
}
