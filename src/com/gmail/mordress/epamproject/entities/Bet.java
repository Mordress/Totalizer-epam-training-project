package com.gmail.mordress.epamproject.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class-Entity, describes user's bet.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class Bet extends Entity {

    /** This field store result of race for distinct horse */
    private HorseRace horseRace;

    /** This field store expected result of race for distinct horse */
    private Integer resultRank;

    /** This field store size of bet's cash(USD). */
    private BigDecimal betAmount;

    /** This field store size of gain cash(USD). */
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
