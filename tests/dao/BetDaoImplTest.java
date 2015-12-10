package dao;

import com.gmail.mordress.lab4.dao.implementation.*;
import com.gmail.mordress.lab4.dao.interfaces.*;
import com.gmail.mordress.lab4.domain.*;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BetDaoImplTest {

    public static void main(String[] args) {
        try {
            DaoFactory factory = new DaoFactoryImpl();
            BetDaoImpl bdi = factory.createDao(BetDao.class);
            //Bet bet = bdi.read(3);
            //System.out.println(bet);

           /* UserDaoImpl udi = factory.createDao(UserDao.class);
            User user = udi.read(4);

            List<Bet> bets = bdi.findWinnedBetsByUser(user);
            for (Bet bet : bets) {
                System.out.println(bet);
            }*/
            BreedDaoImpl brdi = factory.createDao(BreedDao.class);
            HorseDaoImpl hdi = factory.createDao(HorseDao.class);
            RaceDaoImpl rdi = factory.createDao(RaceDao.class);
            UserDaoImpl udi = factory.createDao(UserDao.class);
            HorseRaceDao hrdi = factory.createDao(HorseRaceDao.class);

            Horse horse = hdi.read(1);
            Breed breed = brdi.read(1);
            horse.setBreed(breed);
            System.out.println(horse);

            Race race = rdi.read(1);
            System.out.println(race);
            HorseRace horseRace = hrdi.read(1);
            System.out.println(horseRace);
            horseRace.setHorse(horse);
            horseRace.setRace(race);
            System.out.println(horseRace);

            User user = udi.read(3);
            Bet bet = new Bet();
            bet.setId(4);
            bet.setHorseRace(horseRace);
            bet.setUser(user);
            bet.setCreatedDate(new Date());
            bet.setBetAmount(new BigDecimal("10.2"));
            bet.setWinAmount(new BigDecimal("20.4"));
            bet.setIsWinner(false);
            bet.setResultRank(3);

            System.out.println(bet);
            bdi.create(bet);
            bet.setIsWinner(true);
            bdi.update(bet);




        } catch (PersistentException e1) {
            e1.printStackTrace();
        }

        ;
        //TODO other test
    }
}
