package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Provides operations for user-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface UserService extends Service {

    /** Returns user, found by login and password.
     * @param login user's login.
     * @param password user's password.
     * @return User instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public User findUser(String login, String password) throws PersistentException;

    /** Check for exists some login.
     * @param login - user's login.
     * @return Boolean value, true if that login NOT currently exist in db.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public boolean checkUniqueLogin(String login) throws PersistentException;

    /** Returns all users, not bookmakers and not administrators.
     * @return List of user instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public List<User> getAllSimpleUsers() throws PersistentException;

    /** Returns user instances by id.
     * @param id - user's id.
     * @return user instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public User findById(Integer id) throws PersistentException;

    /** Saves changes to user, or create new user.
     * @param user - changed/new user.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void save(User user) throws PersistentException;

    /** Deletes user by id.
     * @param id - user's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    public void delete(Integer id) throws PersistentException;

    /** Update user's cash amount.
     * @param userId - user's id.
     * @param newCashAmount - value of new cash for user.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    public void updateUserCash(Integer userId, BigDecimal newCashAmount) throws PersistentException;
}
