package com.gmail.mordress.lab4.dao;

import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;

import java.util.List;

public interface HorseDao  extends Dao<Horse> {

    public Horse findByName(String name) throws DaoException;

    public List<Horse> findHorsesByBreed(Breed breed) throws DaoException;

    public List<Horse> getAllHorses() throws DaoException;

}
