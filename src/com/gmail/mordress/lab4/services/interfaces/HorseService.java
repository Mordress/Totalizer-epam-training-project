package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.ServiceException;

import java.util.List;

public interface HorseService extends Service {

    public Horse findByName(String name) throws ServiceException;

    public Horse findHorseById(Integer id) throws ServiceException;

    public List<Horse> findHorsesByBreed(Breed breed) throws ServiceException;

    public List<Horse> getAllHorses() throws ServiceException;


}
