package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Bet;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

public interface BetDao extends Dao<Bet> {

    public List<Bet> findAllBetsByUser(User user) throws PersistentException;

    public List<Bet> findWinnedBets() throws PersistentException;

    public List<Bet> findWinnedBetsByUser(User user) throws PersistentException;

    public List<Bet> findNotCompleteBets() throws PersistentException;

}
