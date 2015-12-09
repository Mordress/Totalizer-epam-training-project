package dao;

import com.gmail.mordress.lab4.dao.implementation.*;
import com.gmail.mordress.lab4.dao.interfaces.*;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;

public class HorseRaceDaoImplTest {

    public static void main(String[] args) {

        try {
            DaoFactory factory = new DaoFactoryImpl();
            HorseRaceDaoImpl hrdi = factory.createDao(HorseRaceDao.class);
            /*System.out.println(hrdi.read(1));*/
            HorseDaoImpl hdi = factory.createDao(HorseDao.class);
            RaceDaoImpl rdi = factory.createDao(RaceDao.class);
            BreedDaoImpl bdi = factory.createDao(BreedDao.class);

            HorseRace horseRace = hrdi.read(21);
            Horse horse = hdi.read(horseRace.getHorse().getId());
            Breed breed = bdi.read(horse.getBreed().getId());
            horse.setBreed(breed);
            Race race = rdi.read(horseRace.getRace().getId());
            horseRace.setHorse(horse);
            horseRace.setRace(race);
            System.out.println(horseRace);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
