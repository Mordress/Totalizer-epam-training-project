package com.gmail.mordress.epamproject.entities;

import java.util.Date;

/**
 * Class-Entity, describes results of race for each horse.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseRace extends Entity {

    private Race race;

    private Horse horse;

    private Integer resultRank;

    private Date resultTime;

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Integer getResultRank() {
        return resultRank;
    }

    public void setResultRank(Integer resultRank) {
        this.resultRank = resultRank;
    }

    public Date getResultTime() {
        return resultTime;
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    @Override
    public String toString() {
        return new StringBuilder("HorseRace:{")
                .append("HorseRaceId = ").append(this.getId())
                .append(", race = ").append(race)
                .append(", horse = ").append(horse)
                .append(", resultRank = ").append(resultRank)
                .append(", resultTime = ").append(resultTime)
                .append("}")
                .toString();
    }
}
