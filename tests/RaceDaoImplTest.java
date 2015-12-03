import com.gmail.mordress.lab4.dao.implementation.BreedDaoImpl;
import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.implementation.RaceDaoImpl;
import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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



        } catch (DaoException | PersistentException e) {
            e.printStackTrace();
        }
    }
}
