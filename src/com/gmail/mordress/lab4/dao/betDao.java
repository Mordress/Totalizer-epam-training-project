package com.gmail.mordress.lab4.dao;

import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;

import java.util.List;

public interface betDao extends Dao<Bet> {

    public List<Bet> findAllBetsByUser(User user) throws DaoException;

    public List<Bet> findWinnedBets() throws DaoException;

    public List<Bet> findWinnedBetsByUser(User user) throws DaoException;

    public boolean isBetPassed(Bet bet);

}
