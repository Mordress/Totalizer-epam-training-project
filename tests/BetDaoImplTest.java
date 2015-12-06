import com.gmail.mordress.lab4.dao.implementation.BetDaoImpl;
import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.interfaces.BetDao;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.PersistentException;

public class BetDaoImplTest {

    public static void main(String[] args) {
        try {

        DaoFactory factory = new DaoFactoryImpl();
        BetDaoImpl bdi = factory.createDao(BetDao.class);

        System.out.println(bdi.read(1));
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (PersistentException e1) {
            e1.printStackTrace();
        }

    }
}
