package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

public interface HorseRaceDao extends Dao<HorseRace> {

    public List<HorseRace> findByRace(Race race) throws PersistentException;

    public HorseRace findByRaceAndHorse(Integer horseId, Integer raceId) throws PersistentException;

    public List<HorseRace> getAllHorseRaces() throws PersistentException;

    public List<HorseRace> getHorseRacePerHorse(Horse horse) throws PersistentException;



}
