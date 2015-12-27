package dao;

import com.gmail.mordress.lab4.dao.mysql.*;
import com.gmail.mordress.lab4.dao.interfaces.*;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import java.util.Date;

public class HorseRaceDaoImplTest {

    public static void main(String[] args) {

        try {
            DaoFactory factory = new DaoFactoryImpl();
            HorseRaceDaoImpl hrdi = factory.createDao(HorseRaceDao.class);
            System.out.println(hrdi.read(1));
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

            System.out.println(horse.getId());
            horseRace.setResultTime(new Date());
            horseRace.setResultRank(3);
            hrdi.update(horseRace);
            hrdi.create(horseRace);

            HorseRace horseRace1 = hrdi.findByRaceAndHorse(1, 2);
            System.out.println(horseRace1.getId());
            System.out.println(horseRace1);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
