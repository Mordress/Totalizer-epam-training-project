package com.gmail.mordress.lab4.dao;

import com.gmail.mordress.lab4.dao.Dao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.exceptions.PersistentException;

public interface BreedDao extends Dao<Breed, Integer>{

    Breed find(String name) throws PersistentException;
}
