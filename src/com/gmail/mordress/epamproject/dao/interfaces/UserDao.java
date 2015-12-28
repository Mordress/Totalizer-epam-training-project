package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Provides additional operations for user-interaction with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface UserDao extends Dao<User> {

    /** Returns user, found by login and password.
     * @param login user's login.
     * @param password user's password.
     * @return User instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public User findUser(String login, String password) throws PersistentException;

    /** Check for exists some login.
     * @param login - user's login.
     * @return Boolean value, true if that login NOT currently exist in db.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public boolean checkUniqueLogin(String login) throws PersistentException;

    /** Returns all users, not bookmakers and not administrators.
     * @return List of user instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public List<User> getAllSimpleUsers() throws PersistentException;

    /** Update user's cash amount.
     * @param userId - user's id.
     * @param newCashAmount - value of new cash for user.
     * @return List of user instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public void updateUserCash(Integer userId, BigDecimal newCashAmount) throws PersistentException;
}
