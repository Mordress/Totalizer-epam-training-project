package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

public interface RaceService extends Service {

    public List<Race> getPassedRaces() throws PersistentException;

    public List<Race> getFutureRaces() throws PersistentException;

    public Race findById(Integer id) throws PersistentException;

    public void save(Race race) throws PersistentException;

    public void delete(Integer id) throws PersistentException;
}
