package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.dao.interfaces.UserDao;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface BetService extends Service{

    public List<Bet> findAllBetsByUser(User user) throws PersistentException;

    public List<Bet> findNotFixedBets() throws PersistentException;

    public List<Bet> findNoFinishedBets() throws PersistentException;

    public void save(Bet bet) throws PersistentException;

    public Bet read(Integer id) throws PersistentException;

    public void delete(Integer id) throws PersistentException;
}
