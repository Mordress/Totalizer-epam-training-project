package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface HorseService extends Service {

    public Horse findByName(String name) throws PersistentException;

    public Horse findHorseById(Integer id) throws PersistentException;

    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException;

    public List<Horse> getAllHorses() throws PersistentException;


}
