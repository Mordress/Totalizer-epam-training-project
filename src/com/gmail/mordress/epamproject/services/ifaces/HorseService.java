package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

public interface HorseService extends Service {

    public Horse findByName(String name) throws PersistentException;

    public Horse findHorseById(Integer id) throws PersistentException;

    public List<Horse> findHorsesByBreed(Breed breed) throws PersistentException;

    public List<Horse> getAllHorses() throws PersistentException;


}
