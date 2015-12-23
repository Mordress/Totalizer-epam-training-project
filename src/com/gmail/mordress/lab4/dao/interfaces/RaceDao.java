package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import java.util.List;

public interface RaceDao extends Dao<Race> {

    public List<Race> getPassedRaces() throws PersistentException;

    public List<Race> getFutureRaces() throws PersistentException;




}
