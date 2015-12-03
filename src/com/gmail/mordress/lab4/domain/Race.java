package com.gmail.mordress.lab4.domain;

import java.util.Date;

public class Race extends Entity {

    private Date raceDate;

    private Integer distance;

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceDate=" + raceDate +
                ", distance=" + distance +
                '}';
    }
}
