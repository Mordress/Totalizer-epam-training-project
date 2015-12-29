package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.UserDao;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.UserService;
import com.gmail.mordress.epamproject.utils.Hasher;
import java.math.BigDecimal;
import java.util.List;

/**
 * Provides operations for user-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class UserServiceImpl extends ServiceImpl implements UserService {

    /** Returns user, found by login and password.
     * @param login user's login.
     * @param password user's password.
     * @return User instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public User findUser(String login, String password) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.findUser(login, hashing(password));
    }

    /** Check for exists some login.
     * @param login - user's login.
     * @return Boolean value, true if that login NOT currently exist in db.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public boolean checkUniqueLogin(String login) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.checkUniqueLogin(login);
    }

    /** Returns all users, not bookmakers and not administrators.
     * @return List of user instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public List<User> getAllSimpleUsers() throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.getAllSimpleUsers();
    }

    /** Returns user instances by id.
     * @param id - user's id.
     * @return user instances.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public User findById(Integer id) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.read(id);
    }

    /** Saves changes to user, or create new user.
     * @param user - changed/new user.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    @Override
    public void save(User user) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        if (user.getId() != null) {
            if (user.getPassword() != null) {
                user.setPassword(hashing(user.getPassword()));
            } else {
                User oldUser = dao.read(user.getId());
                user.setPassword(oldUser.getPassword());
            }
            dao.update(user);
        } else {
            if (user.getLogin() != null) {
                user.setId(dao.create(user));
            }
        }
    }

    /** Deletes user by id.
     * @param id - user's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    @Override
    public void delete(Integer id) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        dao.delete(id);

    }

    /** Update user's cash amount.
     * @param userId - user's id.
     * @param newCashAmount - value of new cash for user.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public void updateUserCash(Integer userId, BigDecimal newCashAmount) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        dao.updateUserCash(userId, newCashAmount);
    }

    /** Hashing input string with password.
     * @param input - password string.
     * @return hashed password. */
    private String hashing(String input) {
        return Hasher.SHA256(input);
    }
}
