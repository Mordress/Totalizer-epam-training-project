package com.gmail.mordress.lab4.validators;

import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;

import java.util.Date;
import java.util.List;

public class RaceValidator {

    private static RaceValidator instance;

    private RaceValidator() {}

    public static synchronized RaceValidator getInstance(){
        if (instance == null) {
            instance = new RaceValidator();
        }
        return instance;
    }

    public boolean isRaceNotPassed(Race race){
        if (race.getRaceDate().getTime() < new Date().getTime()) {
            return false;
        }
        return true;
    }
}
