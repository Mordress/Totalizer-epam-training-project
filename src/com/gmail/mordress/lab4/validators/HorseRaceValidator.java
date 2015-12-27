package com.gmail.mordress.lab4.validators;

import com.gmail.mordress.lab4.entities.HorseRace;

import java.util.List;

public class HorseRaceValidator {

    private static HorseRaceValidator instance;

    private HorseRaceValidator() {}

    public static synchronized HorseRaceValidator getInstance(){
        if (instance == null) {
            instance = new HorseRaceValidator();
        }
        return instance;
    }
    
    public boolean isRankPossible(List<HorseRace> horseRaces, Integer newRank) {
        if (newRank.equals(0)) {
            return true;
        }
        for (HorseRace horseRace : horseRaces) {

            if (horseRace.getResultRank().equals(newRank)) {
                return false;
            }
        }
        return true;
    }
}


