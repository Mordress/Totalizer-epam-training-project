package com.gmail.mordress.epamproject.entities;

import java.util.Date;

/**
 * Class-Entity, describes race.
 * @author Alexey Kardychko
 * @version 1.0
 */
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
        return new StringBuilder("Race:{")
                .append("RaceId = ").append(this.getId())
                .append(", raceDate = ").append(raceDate)
                .append(", distance = ").append(distance)
                .append("}")
                .toString();
    }
}
