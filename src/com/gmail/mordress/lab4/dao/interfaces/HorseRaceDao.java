package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface HorseRaceDao extends Dao<HorseRace> {

    public List<HorseRace> findByRace(Race race) throws PersistentException;

    public List<HorseRace> getAllHorseRaces() throws PersistentException;

    public List<HorseRace> getStatisticPerHorse(Horse horse) throws PersistentException;



}
