package services;

import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.implementation.RaceDaoImpl;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.implementations.HorseRaceServiceImpl;
import com.gmail.mordress.lab4.services.implementations.RaceServiceImpl;
import com.gmail.mordress.lab4.services.implementations.ServiceFactoryImpl;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;
import com.gmail.mordress.lab4.services.interfaces.RaceService;
import com.gmail.mordress.lab4.services.interfaces.ServiceFactory;

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
