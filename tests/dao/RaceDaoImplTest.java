package dao;

import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.implementation.RaceDaoImpl;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public class RaceDaoImplTest {

    public static void main(String[] args) {
        try {
            DaoFactory instance = new DaoFactoryImpl();
            RaceDaoImpl rdi = instance.createDao(RaceDao.class);

            //test race.create
            /*
            Race race = new Race();
            race.setId(12);
            race.setRaceDate(new Date());
            race.setDistance(1200);
            System.out.println(rdi.create(race));
            */

            //test race.read + race.update

            /*
            Race neoRace = rdi.read(1);
            System.out.println(neoRace);
            neoRace.setDistance(1);
            rdi.update(neoRace);
            */

            //test race.delete
            /*rdi.delete(2);*/


            //test race.getPassedRaces() and getFutureRaces()
            List<Race> passed = rdi.getPassedRaces();
            for (Race race : passed) {
                System.out.println(race);
            }
            System.out.println("* * * *");
            List<Race> future = rdi.getFutureRaces();
            for (Race race : future) {
                System.out.println(race);
            }

            List<Race> passed1 = rdi.getPassedRaces();
            for (Race race : passed1) {
                System.out.println(race);
            }
            System.out.println("* * * *");
            List<Race> future2 = rdi.getFutureRaces();
            for (Race race : future2) {
                System.out.println(race);
            }



        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}
