package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.entities.Breed;
import com.gmail.mordress.lab4.entities.Horse;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import java.util.List;

public interface HorseDao  extends Dao<Horse> {

    public Horse findByName(String name) throws PersistentException;

    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException;

    public List<Horse> getAllHorses() throws PersistentException;

}
