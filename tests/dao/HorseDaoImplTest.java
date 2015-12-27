package dao;

import com.gmail.mordress.epamproject.dao.mysql.DaoFactoryImpl;
import com.gmail.mordress.epamproject.dao.mysql.HorseDaoImpl;
import com.gmail.mordress.epamproject.dao.interfaces.DaoFactory;
import com.gmail.mordress.epamproject.dao.interfaces.HorseDao;
import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

public class HorseDaoImplTest {

    public static void main(String[] args) {
        try {
            DaoFactory instance = new DaoFactoryImpl();
            HorseDaoImpl hdi = instance.createDao(HorseDao.class);
            Horse horse1 = hdi.read(2);
            System.out.println(horse1);

            Horse horse2 = new Horse();
            horse2.setId(3);
            horse2.setName("addddd");
            horse2.setAge(11);
            horse2.setWeight(99);
            Breed breed2 = new Breed();
            breed2.setId(1);
            breed2.setName("Орловский рысак");
            horse2.setBreed(breed2);
            hdi.update(horse2);

            List<Horse> horses = hdi.getAllHorses();
            for (Horse horse : horses) {
                System.out.println(horse);
            }

            Breed breed = new Breed();
            breed.setId(3);
            List<Horse> horsez = hdi.findHorsesByBreed(breed);
            for (Horse horse : horsez) {
                System.out.println(horse);
            }
            Horse horse = hdi.findByName("Зератул");
            System.out.println(horse);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

    }
}
