package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.HorseRaceDao;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.util.List;

public class HorseRaceDaoImpl extends BaseDaoImpl implements HorseRaceDao {

    private static Logger logger = Logger.getLogger(HorseRaceDaoImpl.class);

    @Override
    public HorseRace findByHorse(Horse horse) throws DaoException {
        return null;
    }

    @Override
    public HorseRace findByRace(Race race) throws DaoException {
        return null;
    }

    @Override
    public List<HorseRace> getAllHorseRacesByHorse(Horse horse) throws DaoException {
        return null;
    }

    @Override
    public List<HorseRace> getAllHorseRaces() throws DaoException {
        return null;
    }

    @Override
    public Integer create(HorseRace instance) throws DaoException {
        return null;
    }

    @Override
    public HorseRace read(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(HorseRace instance) throws DaoException {

    }

    @Override
    public void delete(Integer id) throws DaoException {

    }
}
