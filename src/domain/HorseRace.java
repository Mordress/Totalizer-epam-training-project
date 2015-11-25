package domain;

import java.util.Calendar;

public class HorseRace extends Entity {

    private Race race;

    private Horse horse;

    private Integer resultRank;

    private Calendar resultTime;

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

    public Calendar getResultTime() {
        return resultTime;
    }

    public void setResultTime(Calendar resultTime) {
        this.resultTime = resultTime;
    }
}
