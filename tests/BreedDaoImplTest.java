import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.dao.implementation.BreedDaoImpl;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public class BreedDaoImplTest {

    public static void main(String[] args) {
        try {
            DaoFactory instance = new DaoFactoryImpl();
            BreedDaoImpl bdi = instance.createDao(BreedDao.class);
            List<Breed> breeds = bdi.getAllBreeds();
            for (Breed breed : breeds) {
                System.out.println(breed.getId() + " " + breed.getName());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}