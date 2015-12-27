package services;

import com.gmail.mordress.lab4.dao.mysql.DaoFactoryImpl;
import com.gmail.mordress.lab4.entities.Bet;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.impls.ServiceFactoryImpl;
import com.gmail.mordress.lab4.services.ifaces.BetService;
import com.gmail.mordress.lab4.services.ifaces.ServiceFactory;
import java.util.List;

public class BetServiceImplTest {

    public static void main(String[] args) {
        try {
            ServiceFactory factory = new ServiceFactoryImpl(new DaoFactoryImpl());
            BetService betService = factory.getService(BetService.class);
            List<Bet> bets = betService.findNoFinishedBets();
            for (Bet bet : bets) {
                System.out.println(bets);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}
