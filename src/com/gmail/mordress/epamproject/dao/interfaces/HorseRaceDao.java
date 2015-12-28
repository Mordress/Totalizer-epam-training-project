package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

/**
 * Provides additional operations for results horse and race to interaction with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface HorseRaceDao extends Dao<HorseRace> {

    /** Returns all horseRace instances with same race.
     * @param race - Race.
     * @return List of HorseRace instances.
     * @throws PersistentException - if DBMS can't successful comlete this operation. */
    public List<HorseRace> findByRace(Race race) throws PersistentException;

    /** Returns all horseRace instances with same race and same horse.
     * @param horseId - Horse instance id.
     * @param raceId - Race instance id.
     * @return List of HorseRace instances.
     * @throws PersistentException - if DBMS can't successful comlete this operation. */
    public HorseRace findByRaceAndHorse(Integer horseId, Integer raceId) throws PersistentException;

    public List<HorseRace> getAllHorseRaces() throws PersistentException;

    public List<HorseRace> getHorseRacePerHorse(Horse horse) throws PersistentException;



}
