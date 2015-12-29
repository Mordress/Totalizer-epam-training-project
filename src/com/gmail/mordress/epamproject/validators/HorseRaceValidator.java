package com.gmail.mordress.epamproject.validators;

import com.gmail.mordress.epamproject.entities.HorseRace;

import java.util.List;

/**
 * Validator for horseRaces.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseRaceValidator {

    private static HorseRaceValidator instance;

    private HorseRaceValidator() {}

    public static synchronized HorseRaceValidator getInstance(){
        if (instance == null) {
            instance = new HorseRaceValidator();
        }
        return instance;
    }

    /** Checks duplicates results horse's ranks at same race.
     * @param horseRaces - list of results for same race.
     * @param newRank - user's input new rank for horse.
     * @return true if no duplicates, and false if new rank already has other horse. */
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


