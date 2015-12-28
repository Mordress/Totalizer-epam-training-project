package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.Bet;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.util.List;

/**
 * Provides additional operations for bet to interaction with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface BetDao extends Dao<Bet> {

    /** Returns all bets by some user.
     * @param user - user.
     * @return List of user's bets
     * @throws PersistentException - if DBMS can't successful comlete this operation. */
    public List<Bet> findAllBetsByUser(User user) throws PersistentException;

    /** Returns all bets, which winned in racing.
     * @return List of bets.
     * @throws PersistentException - if DBMS can't successful comlete this operation. */
    public List<Bet> findWinnedBets() throws PersistentException;

    /** Returns all bets, which winned in racing, by some user.
     * @return List of user's bets.
     * @throws PersistentException - if DBMS can't successful comlete this operation. */
    public List<Bet> findWinnedBetsByUser(User user) throws PersistentException;

    /** Returns all bets, which have no been processed by bookmaker.
     * @return List of bets.
     * @throws PersistentException - if DBMS can't successful comlete this operation. */
    public List<Bet> findNotCompleteBets() throws PersistentException;
}
