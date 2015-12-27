package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

public interface RaceDao extends Dao<Race> {

    public List<Race> getPassedRaces() throws PersistentException;

    public List<Race> getFutureRaces() throws PersistentException;




}
