package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.HorseDao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.HorseService;
import org.apache.log4j.Logger;

import java.util.List;

public class HorseServiceImpl extends ServiceImpl implements HorseService {

    private static Logger logger = Logger.getLogger(HorseServiceImpl.class);

    @Override
    public Horse findByName(final String name) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        Horse horse = horseDao.findByName(name);
        buildHorse(horse);
        return horse;
    }

    @Override
    public Horse findHorseById(final Integer id) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        Horse horse = horseDao.read(id);
        buildHorse(horse);
        return horse;
    }

    @Override
    public List<Horse> findHorsesByBreed(final Breed breed) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        List<Horse> horses = horseDao.findHorsesByBreed(breed);
        buildHorseList(horses);
        return horses;
    }

    @Override
    public List<Horse> getAllHorses() throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        List<Horse> horses = horseDao.getAllHorses();
        buildHorseList(horses);
        return horses;
    }

    /* Собираем коня по частям из разных DAO */
    private void buildHorse(Horse horse) throws PersistentException {
        BreedDao breedDao = factory.createDao(BreedDao.class);
        if (horse != null) {
            Breed breed = breedDao.read(horse.getBreed().getId());
            horse.setBreed(breed);
        }
    }

    private void buildHorseList(List<Horse> horses) throws PersistentException {
        for (Horse horse : horses) {
            if (horse != null) {
                buildHorse(horse);
            }
        }
    }
}
