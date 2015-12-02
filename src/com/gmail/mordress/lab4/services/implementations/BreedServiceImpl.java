package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.BreedDao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.ServiceException;
import com.gmail.mordress.lab4.services.interfaces.BreedService;

import java.util.List;

public class BreedServiceImpl extends ServiceImpl implements BreedService {
    @Override
    public Breed findByName(String name) throws ServiceException {
        try {
            BreedDao dao = factory.createDao(BreedDao.class);
            return dao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Breed> getAllBreeds() throws ServiceException {
        try {
            BreedDao dao = factory.createDao(BreedDao.class);
            return dao.getAllBreeds();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void save(Breed breed) throws ServiceException {
        try {
            BreedDao dao = factory.createDao(BreedDao.class);
            if (breed.getId() != null) {
                dao.update(breed);
            } else {
                breed.setId(dao.create(breed));
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            BreedDao dao = factory.createDao(BreedDao.class);
            dao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }
}
