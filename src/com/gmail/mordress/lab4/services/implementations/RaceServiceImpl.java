package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.ServiceException;
import com.gmail.mordress.lab4.services.interfaces.RaceService;

import java.util.List;

public class RaceServiceImpl extends ServiceImpl implements RaceService {

    @Override
    public List<Race> getPassedRaces() throws ServiceException {
        try {
            RaceDao raceDao = factory.createDao(RaceDao.class);
            return raceDao.getPassedRaces();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Race> getFutureRaces() throws ServiceException {
        try {
            RaceDao raceDao = factory.createDao(RaceDao.class);
            return raceDao.getFutureRaces();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Race findById(Integer id) throws ServiceException {
        try {
            RaceDao raceDao = factory.createDao(RaceDao.class);
            return raceDao.read(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void save(Race race) throws ServiceException {

    }

    @Override
    public void delete(Integer id) throws ServiceException {

    }
}
