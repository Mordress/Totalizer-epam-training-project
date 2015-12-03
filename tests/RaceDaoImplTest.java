import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.implementation.RaceDaoImpl;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.PersistentException;

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



        } catch (DaoException | PersistentException e) {
            e.printStackTrace();
        }
    }
}
