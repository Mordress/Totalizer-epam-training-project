package com.gmail.mordress.epamproject.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Bet extends Entity {

    private HorseRace horseRace;

    private Integer resultRank;

    private BigDecimal betAmount;

    private BigDecimal winAmount;

    private Boolean isWinner;

    private User user;

    private Date createdDate;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return new StringBuilder("Bet:{")
                .append("BetId = ").append(this.getId())
                .append(", horseRace = ").append(horseRace)
                .append(", resultRank = ").append(resultRank)
                .append(", betAmount = ").append(betAmount)
                .append(", isWinner = ").append(isWinner)
                .append(", user = ").append(user)
                .append(", createdDate = ").append(createdDate)
                .append("}")
                .toString();
    }
}
