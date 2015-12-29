package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.BreedDao;
import com.gmail.mordress.epamproject.dao.interfaces.HorseDao;
import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Provides operations for horse-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseServiceImpl extends ServiceImpl implements HorseService {

    private static Logger logger = Logger.getLogger(HorseServiceImpl.class);

    /** Returns horse instance found by name.
     * @param name - horse's name.
     * @return Horse instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public Horse findByName(String name) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        Horse horse = horseDao.findByName(name);
        buildHorse(horse);
        return horse;
    }

    /** Returns horse instance found by id.
     * @param id - horse's id.
     * @return Horse instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public Horse findHorseById(Integer id) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        Horse horse = horseDao.read(id);
        buildHorse(horse);
        return horse;
    }

    /** Returns all horses with same breed.
     * @param breed - Some breed instance.
     * @return List of Horses.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException {
        HorseDao horseDao = factory.createDao(HorseDao.class);
        List<Horse> horses = horseDao.findHorsesByBreed(breed);
        buildHorseList(horses);
        return horses;
    }

    /** Returns all possible horses.
     * @return List of Horses.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
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
