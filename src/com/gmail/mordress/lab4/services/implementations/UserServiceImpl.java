package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.UserDao;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import com.gmail.mordress.lab4.services.interfaces.UserService;
import com.gmail.mordress.lab4.utils.Hasher;

import java.math.BigDecimal;
import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {

    @Override
    public User findUser(final String login, String password) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.findUser(login, hashing(password));
    }

    @Override
    public boolean checkUniqueLogin(final String login) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.checkUniqueLogin(login);
    }

    @Override
    public List<User> getAllSimpleUsers() throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.getAllSimpleUsers();
    }

    @Override
    public User findById(final Integer id) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        return dao.read(id);
    }

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
                user.setPassword(hashing(user.getLogin()));
                user.setId(dao.create(user));
            }
        }
    }

    @Override
    public void delete(final Integer id) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        dao.delete(id);

    }

    private String hashing(String input) {
        return Hasher.SHA256(input);
    }

    @Override
    public void updateUserCash(Integer userId, BigDecimal newCashAmount) throws PersistentException {
        UserDao dao = factory.createDao(UserDao.class);
        dao.updateUserCash(userId, newCashAmount);
    }
}
