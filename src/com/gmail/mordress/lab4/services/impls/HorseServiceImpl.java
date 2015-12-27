package com.gmail.mordress.lab4.services.impls;

import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.HorseDao;
import com.gmail.mordress.lab4.entities.Breed;
import com.gmail.mordress.lab4.entities.Horse;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.ifaces.HorseService;
import org.apache.log4j.Logger;

import java.util.List;

public class HorseServiceImpl extends ServiceImpl implements HorseService {

    private static Logger logger = Logger.getLogger(HorseServiceImpl.class);

    @Override
    public Horse findByName(String name) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        Horse horse = horseDao.findByName(name);
        buildHorse(horse);
        return horse;
    }

    @Override
    public Horse findHorseById(Integer id) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        Horse horse = horseDao.read(id);
        buildHorse(horse);
        return horse;
    }

    @Override
    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException {
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

    /* Create sterling instance Horse from id-s*/
    private void buildHorse(Horse horse) throws PersistentException {
        BreedDao breedDao = factory.createDao(BreedDao.class);
        if (horse != null) {
            Breed breed = breedDao.read(horse.getBreed().getId());
            horse.setBreed(breed);
        }
    }
    /* Create sterling instance for each Horse in List from id-s*/
    private void buildHorseList(List<Horse> horses) throws PersistentException {
        for (Horse horse : horses) {
            if (horse != null) {
                buildHorse(horse);
            }
        }
    }
}
