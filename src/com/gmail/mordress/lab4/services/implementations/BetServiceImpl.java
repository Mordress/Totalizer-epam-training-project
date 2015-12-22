package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.*;
import com.gmail.mordress.lab4.domain.*;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.BetService;
import com.gmail.mordress.lab4.services.interfaces.HorseRaceService;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public void save(Bet bet) throws PersistentException {
        BetDao betDao = factory.createDao(BetDao.class);
        if (bet.getId() != null) {
            betDao.update(bet);
        } else {
            bet.setId(betDao.create(bet));
        }
    }

    @Override
    public List<Bet> findNotFixedBets() throws PersistentException {
        BetDao betDao = factory.createDao(BetDao.class);
        List<Bet> notCompleteBets = betDao.findNotCompleteBets();
        for (Bet notCompleteBet : notCompleteBets) {
            betBuild(notCompleteBet);
        }
        List<Bet> notFixedBets = new ArrayList<>();
        for (Bet bet : notCompleteBets) {
            if (bet.getHorseRace().getRace().getRaceDate().getTime() < new Date().getTime()) {
                notFixedBets.add(bet);
            }
        }
        return notFixedBets;
    }

    @Override
    public List<Bet> findNoFinishedBets() throws PersistentException {
        BetDao betDao = factory.createDao(BetDao.class);
        List<Bet> notCompleteBets = betDao.findNotCompleteBets();
        for (Bet notCompleteBet : notCompleteBets) {
            betBuild(notCompleteBet);
        }
        return notCompleteBets;
    }

    @Override
    public Bet read(Integer id) throws PersistentException {
        BetDao betDao = factory.createDao(BetDao.class);
        Bet bet = betDao.read(id);
        betBuild(bet);
        return bet;
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        BetDao betDao = factory.createDao(BetDao.class);
        betDao.delete(id);
    }

    private void betBuild(Bet bet) throws PersistentException {
        UserDao userDao = factory.createDao(UserDao.class);
        User u = userDao.read(bet.getUser().getId());
        bet.setUser(u);

        HorseRaceDao horseRaceDao = factory.createDao(HorseRaceDao.class);
        HorseRace horseRace = horseRaceDao.read(bet.getHorseRace().getId());
        //bet.setHorseRace(horseRace);
        buildHorseRace(horseRace);
        bet.setHorseRace(horseRace);
    }

    private void buildHorseRace(HorseRace hr) {
        if (hr != null && hr.getId() !=null ) {
            try {
                RaceDao raceDao = factory.createDao(RaceDao.class);
                HorseDao horseDao = factory.createDao(HorseDao.class);
                BreedDao breedDao = factory.createDao(BreedDao.class);

                hr.setRace(raceDao.read(hr.getRace().getId()));
                hr.setHorse(horseDao.read(hr.getHorse().getId()));
                Breed breed = breedDao.read(hr.getHorse().getBreed().getId());
                Horse horse = horseDao.read(hr.getHorse().getId());
                horse.setBreed(breed);
                hr.setHorse(horse);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }
    }
}
