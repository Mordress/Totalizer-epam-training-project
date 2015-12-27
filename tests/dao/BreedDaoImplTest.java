package dao;

import com.gmail.mordress.lab4.dao.implementation.BreedDaoImpl;
import com.gmail.mordress.lab4.dao.implementation.DaoFactoryImpl;
import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public class BreedDaoImplTest {

    public static void main(String[] args) {
        try {
            DaoFactory instance = new DaoFactoryImpl();
            BreedDaoImpl bdi = instance.createDao(BreedDao.class);

            /* Testing BreedDaoImpl.getAllBreeds() */
            List<Breed> breeds = bdi.getAllBreeds();
            for (Breed breed : breeds) {
                System.out.println(breed.getId() + " " + breed.getName());
            }

            /*Testing BreedDaoImpl.findByName()*/
            Breed b = bdi.findByName("Американский рысак");
            System.out.println(b);

            /*Testing BreedDaoImpl.create()*/
            Breed br = new Breed();
            br.setName("some");
            br.setId(6);
            Integer i = bdi.create(br);
            System.out.println(i);

            /*Testing read*/
            Integer j = 3;
            Breed brd = bdi.read(j);
            System.out.println(brd);

            /*Testing update*/
            Breed bUpdate = new Breed();
            bUpdate.setId(3);
            bUpdate.setName("Американский гусь");
            bdi.update(bUpdate);

            /*Testing delete*/
            bdi.delete(5);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}