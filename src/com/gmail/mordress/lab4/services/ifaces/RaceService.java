package com.gmail.mordress.lab4.services.ifaces;

import com.gmail.mordress.lab4.entities.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface RaceService extends Service {

    public List<Race> getPassedRaces() throws PersistentException;

    public List<Race> getFutureRaces() throws PersistentException;

    public Race findById(Integer id) throws PersistentException;

    public void save(Race race) throws PersistentException;

    public void delete(Integer id) throws PersistentException;
}
