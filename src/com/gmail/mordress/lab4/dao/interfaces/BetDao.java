package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;

import java.util.List;

public interface BetDao extends Dao<Bet> {

    public List<Bet> findAllBetsByUser(User user) throws DaoException;

    public List<Bet> findWinnedBets() throws DaoException;

    public List<Bet> findWinnedBetsByUser(User user) throws DaoException;

    public boolean isBetPassed(Bet bet);

}
