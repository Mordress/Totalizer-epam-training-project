package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.HorseDao;
import com.gmail.mordress.lab4.dao.interfaces.HorseRaceDao;
import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;

import java.util.List;

public class HorseRaceServiceImpl extends ServiceImpl implements HorseRaceService {

    @Override
    public List<HorseRace> findByRace(Race race) throws PersistentException {
        HorseRaceDao horseRaceDao = factory.createDao(HorseRaceDao.class);
        List<HorseRace> horseRaces = horseRaceDao.findByRace(race);
        RaceDao raceDao = factory.createDao(RaceDao.class);
        HorseDao horseDao = factory.createDao(HorseDao.class);
        BreedDao breedDao = factory.createDao(BreedDao.class);
        if (horseRaces != null && !horseRaces.isEmpty())
        for (HorseRace horseRace : horseRaces) {
            horseRace.setRace(raceDao.read(horseRace.getRace().getId()));
            horseRace.setHorse(horseDao.read(horseRace.getHorse().getId()));
            Breed breed = breedDao.read(horseRace.getHorse().getBreed().getId());
            Horse horse = horseDao.read(horseRace.getHorse().getId());
            horse.setBreed(breed);
            horseRace.setHorse(horse);
            //horseRace.setHorse(horseRace.getHorse().setBreed(breed));
        }
        return horseRaces;
    }

    @Override
    public HorseRace findById(final Integer id) throws PersistentException {
        if (id != null) {
            HorseRaceDao dao = factory.createDao(HorseRaceDao.class);
            return dao.read(id);
        }
        return null;
    }


}
