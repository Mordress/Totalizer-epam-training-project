package com.gmail.mordress.lab4.dao;

import com.gmail.mordress.lab4.domain.Breed;

import java.util.List;

public interface BreedDao extends Dao<Breed> {

    public Breed findByName(String name) throws DaoException;

    public List<Breed> getAllBreeds() throws DaoException;
}
