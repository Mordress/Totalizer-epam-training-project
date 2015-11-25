package domain;

import java.math.BigDecimal;
import java.util.Calendar;

public class Bet extends Entity {

    private HorseRace horseRace;
    private Integer resultRank;
    private Calendar resultTime;
    private BigDecimal betAmount;
    private BigDecimal winAmount;
    private Boolean isWinner;
    private User user;
    private Calendar createdDate;

    public HorseRace getHorseRace() {
        return horseRace;
    }

    public void setHorseRace(HorseRace horseRace) {
        this.horseRace = horseRace;
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

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public BigDecimal getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(BigDecimal winAmount) {
        this.winAmount = winAmount;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }
}
