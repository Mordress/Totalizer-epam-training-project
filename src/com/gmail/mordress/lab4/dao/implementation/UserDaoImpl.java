package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.UserDao;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);


    @Override
    public User findUser(String login, String password) throws DaoException {
        return null;
    }

    @Override
    public boolean checkUniqueLogin(String login) throws DaoException {
        return false;
    }

    @Override
    public boolean isSimpleUser(User user) throws DaoException {
        return false;
    }

    @Override
    public boolean isPositiveCashAmount(User user) throws DaoException {
        return false;
    }

    @Override
    public List<User> getAllSimpleUsers() throws DaoException {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        return null;
    }

    @Override
    public List<Bet> findAllBetsByUser(User user) throws DaoException {
        return null;
    }

    @Override
    public Integer create(User instance) throws DaoException {
        String sql = "INSERT INTO `users` ()";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException e) {

        } finally {

        }
    }

    @Override
    public User read(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(User instance) throws DaoException {

    }

    @Override
    public void delete(Integer id) throws DaoException {

    }
}
