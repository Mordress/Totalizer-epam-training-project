import com.gmail.mordress.lab4.dao.DaoException;
import com.gmail.mordress.lab4.dao.mysql.BaseDaoImpl;
import com.gmail.mordress.lab4.dao.mysql.BreedDaoImpl;
import com.gmail.mordress.lab4.domain.Breed;

import java.util.List;

public class BreedDaoImplTest {

    public static void main(String[] args) {
        BreedDaoImpl instance = new BreedDaoImpl();
        try {
            List<Breed> breeds = instance.getAllBreeds();
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
