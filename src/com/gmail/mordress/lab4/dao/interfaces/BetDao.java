package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface BetDao extends Dao<Bet> {

    public List<Bet> findAllBetsByUser(User user) throws PersistentException;

    public List<Bet> findWinnedBets() throws PersistentException;

    public List<Bet> findWinnedBetsByUser(User user) throws PersistentException;

    public List<Bet> findNotCompleteBets() throws PersistentException;

}
