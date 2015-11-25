package domain;

import java.util.Calendar;

public class Race extends Entity {

    private Calendar raceDate;
    private Integer distance;

    public Calendar getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Calendar raceDate) {
        this.raceDate = raceDate;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
