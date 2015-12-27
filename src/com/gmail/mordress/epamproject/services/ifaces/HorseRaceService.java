package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

public interface HorseRaceService extends Service {

    public List<HorseRace> findByRace(Race race) throws PersistentException;

    public HorseRace findById(Integer id) throws PersistentException;

    public void save(HorseRace horseRace) throws PersistentException;

    public HorseRace findByRaceAndHorse(Integer horseId, Integer raceId) throws PersistentException;
}
