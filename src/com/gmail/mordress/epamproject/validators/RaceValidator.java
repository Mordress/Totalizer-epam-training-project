package com.gmail.mordress.epamproject.validators;

import com.gmail.mordress.epamproject.entities.Race;

import java.util.Date;

/**
 * Validator for creating races.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class RaceValidator {

    private static RaceValidator instance;

    private RaceValidator() {}

    public static synchronized RaceValidator getInstance(){
        if (instance == null) {
            instance = new RaceValidator();
        }
        return instance;
    }

    /** Checks date for new race. Administrator can not create passed races.
     * @param race - new race, just created.
     * @return true if racedate is not passed , and false if it passed. */
    public boolean isRaceNotPassed(Race race){
        if (race.getRaceDate().getTime() < new Date().getTime()) {
            return false;
        }
        return true;
    }
}
