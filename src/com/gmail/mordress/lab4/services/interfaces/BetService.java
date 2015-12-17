package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.util.List;

public interface BetService extends Service{

    public List<Bet> findAllBetsByUser(User user) throws PersistentException;

    public void save(Bet bet) throws PersistentException;


}
