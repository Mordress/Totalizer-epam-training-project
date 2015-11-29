package com.gmail.mordress.lab4.dao;

import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;

import java.util.List;

public interface HorseRaceDao extends Dao<HorseRace> {

    public HorseRace findByHorse(Horse horse) throws DaoException;

    public HorseRace findByRace(Race race) throws DaoException;

    public List<HorseRace> getAllHorseRacesByHorse(Horse horse) throws DaoException;

    public List<HorseRace> getAllHorseRaces() throws DaoException;



}
