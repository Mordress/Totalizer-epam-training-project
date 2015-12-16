package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.BetDao;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BetService;

import java.util.List;

public class BetServiceImpl extends ServiceImpl implements BetService {

    @Override
    public List<Bet> findAllBetsByUser(User user) throws PersistentException {
        BetDao dao = factory.createDao(BetDao.class);
        return dao.findAllBetsByUser(user);
    }
}
