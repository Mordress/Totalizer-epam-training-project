package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.BetDao;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.DaoException;

import java.util.List;

public class BetDaoImpl extends BaseDaoImpl implements BetDao {


    @Override
    public List<Bet> findAllBetsByUser(User user) throws DaoException {
        return null;
    }

    @Override
    public List<Bet> findWinnedBets() throws DaoException {
        return null;
    }

    @Override
    public List<Bet> findWinnedBetsByUser(User user) throws DaoException {
        return null;
    }

    @Override
    public boolean isBetPassed(Bet bet) {
        return false;
    }

    @Override
    public Integer create(Bet instance) throws DaoException {
        return null;
    }

    @Override
    public Bet read(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(Bet instance) throws DaoException {

    }

    @Override
    public void delete(Integer id) throws DaoException {

    }
}
