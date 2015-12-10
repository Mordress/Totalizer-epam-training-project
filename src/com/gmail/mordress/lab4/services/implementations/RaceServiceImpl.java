package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.RaceService;

import java.util.List;

public class RaceServiceImpl extends ServiceImpl implements RaceService {

    @Override
    public List<Race> getPassedRaces() throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        return raceDao.getPassedRaces();
    }

    @Override
    public List<Race> getFutureRaces() throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        return raceDao.getFutureRaces();
    }

    @Override
    public Race findById(final Integer id) throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        return raceDao.read(id);
    }

    @Override
    public void save(Race race) throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        if (race.getId() != null) {
            raceDao.update(race);
        } else {
            race.setId(raceDao.create(race));
        }
    }

    @Override
    public void delete(final Integer id) throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        raceDao.delete(id);
    }
}
