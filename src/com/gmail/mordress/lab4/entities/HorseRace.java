package com.gmail.mordress.lab4.entities;

import java.util.Date;

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
        return "HorseRace{" +
                "race=" + race +
                ", horse=" + horse +
                ", resultRank=" + resultRank +
                ", resultTime=" + resultTime +
                '}';
    }
}
