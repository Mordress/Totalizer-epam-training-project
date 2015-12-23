package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BreedService;
import java.util.List;

public class BreedServiceImpl extends ServiceImpl implements BreedService {
    @Override
    public Breed findByName(final String name) throws PersistentException {
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
    public void delete(final Integer id) throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        dao.delete(id);
    }
}
