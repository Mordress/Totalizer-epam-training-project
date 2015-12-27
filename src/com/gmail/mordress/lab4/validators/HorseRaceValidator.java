package com.gmail.mordress.lab4.validators;

import com.gmail.mordress.lab4.domain.Entity;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.IncorrectUserDataException;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


