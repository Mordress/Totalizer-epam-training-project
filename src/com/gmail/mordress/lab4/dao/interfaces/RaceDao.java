package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;

import java.util.List;

public interface RaceDao extends Dao<Race> {

    public List<Race> getPassedRaces() throws DaoException;

    public List<Race> getFutureRaces() throws DaoException;




}
