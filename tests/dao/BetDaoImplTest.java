package dao;

import com.gmail.mordress.lab4.dao.implementation.BetDaoImpl;
import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.interfaces.BetDao;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.exceptions.PersistentException;

public class BetDaoImplTest {

    public static void main(String[] args) {
        try {

        DaoFactory factory = new DaoFactoryImpl();
        BetDaoImpl bdi = factory.createDao(BetDao.class);

            Bet bet = bdi.read(3);
            System.out.println(bet);
            //bdi.create(bet);
        } catch (PersistentException e1) {
            e1.printStackTrace();
        }
        //TODO other test
    }
}
