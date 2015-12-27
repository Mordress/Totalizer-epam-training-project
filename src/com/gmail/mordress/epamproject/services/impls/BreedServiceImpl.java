package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.BreedDao;
import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.BreedService;
import java.util.List;

public class BreedServiceImpl extends ServiceImpl implements BreedService {
    @Override
    public Breed findByName(String name) throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        return dao.findByName(name);
    }

    @Override
    public List<Breed> getAllBreeds() throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        return dao.getAllBreeds();
    }

    @Override
    public void save(Breed breed) throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        if (breed.getId() != null) {
            dao.update(breed);
        } else {
            breed.setId(dao.create(breed));
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        dao.delete(id);
    }
}
