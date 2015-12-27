package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

public interface HorseDao  extends Dao<Horse> {

    public Horse findByName(String name) throws PersistentException;

    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException;

    public List<Horse> getAllHorses() throws PersistentException;

}
