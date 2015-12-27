package com.gmail.mordress.lab4.validators;

import com.gmail.mordress.lab4.entities.Race;

import java.util.Date;

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
