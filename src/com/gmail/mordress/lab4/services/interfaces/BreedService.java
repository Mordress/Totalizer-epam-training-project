package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.ServiceException;

import java.util.List;

public interface BreedService extends Service {

    public Breed findByName(String name) throws ServiceException;

    public List<Breed> getAllBreeds() throws ServiceException;

    public void save(Breed breed) throws ServiceException;

    public void delete(Integer id) throws ServiceException;


}
