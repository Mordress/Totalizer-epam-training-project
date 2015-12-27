package services;

import com.gmail.mordress.lab4.dao.mysql.DaoFactoryImpl;
import com.gmail.mordress.lab4.entities.HorseRace;
import com.gmail.mordress.lab4.entities.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.impls.ServiceFactoryImpl;
import com.gmail.mordress.lab4.services.ifaces.HorseRaceService;
import com.gmail.mordress.lab4.services.ifaces.RaceService;
import com.gmail.mordress.lab4.services.ifaces.ServiceFactory;

import java.util.List;

public class HorseRaceServiceImplTest {

    public static void main(String[] args) {
        try {
            ServiceFactory factory = new ServiceFactoryImpl(new DaoFactoryImpl());
            HorseRaceService service = factory.getService(HorseRaceService.class);
            RaceService rService = factory.getService(RaceService.class);
            Race race = rService.findById(1);
            List<HorseRace> horseRaces = service.findByRace(race);
            for (HorseRace horseRace : horseRaces) {
                System.out.println(horseRace);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }

    }
}
