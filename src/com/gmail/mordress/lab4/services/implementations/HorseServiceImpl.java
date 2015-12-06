package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.HorseDao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.ServiceException;
import com.gmail.mordress.lab4.services.interfaces.HorseService;
import com.gmail.mordress.lab4.services.interfaces.Service;
import org.apache.log4j.Logger;

import java.util.List;

public class HorseServiceImpl extends ServiceImpl implements HorseService {

    private static Logger logger = Logger.getLogger(HorseServiceImpl.class);

    @Override
    public Horse findByName(final String name) throws ServiceException {
        try {
            HorseDao horseDao = factory.createDao(HorseDao.class);
            Horse horse = horseDao.findByName(name);
            buildHorse(horse);
            return horse;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Horse findHorseById(final Integer id) throws ServiceException {
        try {
            HorseDao horseDao = factory.createDao(HorseDao.class);
            Horse horse = horseDao.read(id);
            buildHorse(horse);
            return horse;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Horse> findHorsesByBreed(final Breed breed) throws ServiceException {
        try {
            HorseDao horseDao = factory.createDao(HorseDao.class);
            List<Horse> horses = horseDao.findHorsesByBreed(breed);
            buildHorseList(horses);
            return horses;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Horse> getAllHorses() throws ServiceException {
        try {
            HorseDao horseDao = factory.createDao(HorseDao.class);
            List<Horse> horses = horseDao.getAllHorses();
            buildHorseList(horses);
            return horses;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    /* Собираем коня по частям из разных DAO */
    private void buildHorse(Horse horse) throws ServiceException {
        try {
            BreedDao breedDao = factory.createDao(BreedDao.class);
            if (horse != null) {
                Breed breed = breedDao.read(horse.getBreed().getId());
                horse.setBreed(breed);
            }
        } catch (DaoException e) {
            logger.debug("Service layer can't build horse with ID = " + horse.getId());
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    private void buildHorseList(List<Horse> horses) throws ServiceException {
        for (Horse horse : horses) {
            if (horse != null) {
                buildHorse(horse);
            }
        }
    }
}
