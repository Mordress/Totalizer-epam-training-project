package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.RaceDao;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.RaceService;

import java.util.List;

/**
 * Provides operations for race-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class RaceServiceImpl extends ServiceImpl implements RaceService {

    /** Returns all currently passed race instances.
     * @return List of HorseRace instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public List<Race> getPassedRaces() throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        return raceDao.getPassedRaces();
    }

    /** Returns all currently not passed race instances.
     * @return List of HorseRace instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public List<Race> getFutureRaces() throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        return raceDao.getFutureRaces();
    }

    /** Returns race instance found by id.
     * @param id - race's id.
     * @return race instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public Race findById(Integer id) throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        return raceDao.read(id);
    }

    /** Saves changes to race, or create new race.
     * @param race - changed/new race.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    @Override
    public void save(Race race) throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        if (race.getId() != null) {
            raceDao.update(race);
        } else {
            race.setId(raceDao.create(race));
        }
    }

    /** Deletes race by id.
     * @param id - race's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    @Override
    public void delete(Integer id) throws PersistentException {
        RaceDao raceDao = factory.createDao(RaceDao.class);
        raceDao.delete(id);
    }
}
