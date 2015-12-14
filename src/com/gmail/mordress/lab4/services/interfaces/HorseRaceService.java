package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface HorseRaceService extends Service {

    public List<HorseRace> findByRace(Race race) throws PersistentException;
}
