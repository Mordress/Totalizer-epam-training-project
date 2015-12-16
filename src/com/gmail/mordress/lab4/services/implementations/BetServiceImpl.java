package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.BetDao;
import com.gmail.mordress.lab4.dao.interfaces.HorseRaceDao;
import com.gmail.mordress.lab4.dao.interfaces.UserDao;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BetService;

import java.util.List;

public class BetServiceImpl extends ServiceImpl implements BetService {

    @Override
    public List<Bet> findAllBetsByUser(User user) throws PersistentException {
        BetDao betDao = factory.createDao(BetDao.class);
        List<Bet> bets =  betDao.findAllBetsByUser(user);
        for (Bet bet : bets) {
            betBuild(bet);
        }
        return bets;
    }

    private void betBuild(Bet bet) throws PersistentException {
        HorseRaceDao horseRaceDao = factory.createDao(HorseRaceDao.class);
        UserDao userDao = factory.createDao(UserDao.class);
        HorseRace horseRace = horseRaceDao.read(bet.getHorseRace().getId());
        User u = userDao.read(bet.getUser().getId());
        bet.setHorseRace(horseRace);
        bet.setUser(u);
    }
}
