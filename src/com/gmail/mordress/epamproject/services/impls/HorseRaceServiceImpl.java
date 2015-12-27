package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.BreedDao;
import com.gmail.mordress.epamproject.dao.interfaces.HorseDao;
import com.gmail.mordress.epamproject.dao.interfaces.HorseRaceDao;
import com.gmail.mordress.epamproject.dao.interfaces.RaceDao;
import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.entities.HorseRace;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.HorseRaceService;

import java.util.List;

public class HorseRaceServiceImpl extends ServiceImpl implements HorseRaceService {

    @Override
    public List<HorseRace> findByRace(Race race) throws PersistentException {
        HorseRaceDao horseRaceDao = factory.createDao(HorseRaceDao.class);
        List<HorseRace> horseRaces = horseRaceDao.findByRace(race);
        if (horseRaces != null && !horseRaces.isEmpty())
        for (HorseRace horseRace : horseRaces) {
            buildHorseRace(horseRace);
        }
        return horseRaces;
    }

    @Override
    public HorseRace findById(Integer id) throws PersistentException {
        if (id != null) {
            HorseRaceDao dao = factory.createDao(HorseRaceDao.class);
            HorseRace horseRace = dao.read(id);
            buildHorseRace(horseRace);
            return horseRace;
        }
        return null;
    }

    @Override
    public void save(HorseRace horseRace) throws PersistentException {
        HorseRaceDao dao = factory.createDao(HorseRaceDao.class);
        if (horseRace.getId() != null) {
            dao.update(horseRace);
        } else {
            horseRace.setId(dao.create(horseRace));
        }
    }

    /* Create sterling instance HorseRace from id-s */
    private void buildHorseRace(HorseRace hr) {
        if (hr != null && hr.getId() !=null ) {
            try {
                RaceDao raceDao = factory.createDao(RaceDao.class);
                HorseDao horseDao = factory.createDao(HorseDao.class);
                BreedDao breedDao = factory.createDao(BreedDao.class);

                hr.setRace(raceDao.read(hr.getRace().getId()));
                hr.setHorse(horseDao.read(hr.getHorse().getId()));
                Breed breed = breedDao.read(hr.getHorse().getBreed().getId());
                Horse horse = horseDao.read(hr.getHorse().getId());
                horse.setBreed(breed);
                hr.setHorse(horse);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public HorseRace findByRaceAndHorse(Integer horseId, Integer raceId) throws PersistentException {
        HorseRaceDao horseRaceDao = factory.createDao(HorseRaceDao.class);
        HorseRace horseRace = horseRaceDao.findByRaceAndHorse(horseId, raceId);
        buildHorseRace(horseRace);
        return horseRace;
    }
}
