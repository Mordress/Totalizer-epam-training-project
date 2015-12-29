package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.Bet;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;

import java.util.List;

/**
 * Provides operations for bet-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface BetService extends Service{

    /** Returns all bets by some user.
     * @param user - user.
     * @return List of user's bets
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public List<Bet> findAllBetsByUser(User user) throws PersistentException;

    /** Returns all not fixed bets by bookmaker.
     * @return List of bets.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public List<Bet> findNotFixedBets() throws PersistentException;

    /** Returns all not finished bets.
     * @return List of bets.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public List<Bet> findNoFinishedBets() throws PersistentException;

    /** Saves changes to bet, or create new bet.
     * @param bet - changed/new bet.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void save(Bet bet) throws PersistentException;

    /** Reads bet from dao-layer.
     * @param id - bet's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public Bet read(Integer id) throws PersistentException;

    /** Deletes bet from dao-layer.
     * @param id - bet's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void delete(Integer id) throws PersistentException;
}
