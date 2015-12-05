package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;

import java.util.List;

public interface HorseRaceDao extends Dao<HorseRace> {

    public List<HorseRace> findByRace(Race race) throws DaoException;

    public List<HorseRace> getAllHorseRaces() throws DaoException;

    public List<HorseRace> getStatisticPerHorse(Horse horse) throws DaoException;



}
