package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.ServiceException;

import java.util.List;

public interface RaceService extends Service {

    public List<Race> getPassedRaces() throws ServiceException;

    public List<Race> getFutureRaces() throws ServiceException;

    public Race findById(Integer id) throws ServiceException;

    public void save(Race race) throws ServiceException;

    public void delete(Integer id) throws ServiceException;
}
