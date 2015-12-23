package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.UserDao;
import com.gmail.mordress.lab4.domain.Role;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User findUser(String login, String password) throws PersistentException {
        String sql = "SELECT * FROM `users` WHERE (`login` = ? AND `password` = ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_ID"));
                user.setLogin(login);
                user.setPassword(password);
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setEmail(resultSet.getString("email"));
                user.setCashAmount(resultSet.getBigDecimal("cash_amount"));
            }
            return user;
        } catch (SQLException e) {
            logger.error("Can not find user by login and password, login = " + login);
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public boolean checkUniqueLogin(String login) throws PersistentException {
        String sql = "SELECT `user_ID` FROM `users` WHERE `login` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            logger.error("Can not check user-login for unique" + login);
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List<User> getAllSimpleUsers() throws PersistentException {
        String sql = "SELECT * FROM `users` WHERE role = 0";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_ID"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setCashAmount(resultSet.getBigDecimal("cash_amount"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            logger.error("Can not get all simple-users");
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }


    @Override
    public Integer create(User instance) throws PersistentException {
        String sql = "INSERT INTO `users` (`login`, `password`, `first_name`, `last_name`, `role`, `email`, `cash_amount`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, instance.getLogin());
            statement.setString(2, instance.getPassword());
            statement.setString(3, instance.getFirstName());
            statement.setString(4, instance.getLastName());
            statement.setInt(5, instance.getRole().getId());
            statement.setString(6, instance.getEmail());
            statement.setBigDecimal(7, instance.getCashAmount());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `users`");
                throw new PersistentException();
            }

        } catch (SQLException e) {
            logger.error("Can not create instance of user in db for user with login = " + instance.getLogin());
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }

    }

    @Override
    public User read(Integer id) throws PersistentException {
        String sql = "SELECT * FROM `users` WHERE user_ID = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setEmail(resultSet.getString("email"));
                user.setCashAmount(resultSet.getBigDecimal("cash_amount"));
            }
            return user;
        } catch(SQLException e) {
            logger.error("Can not read user from db with id = " + id);
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void update(User instance) throws PersistentException {
        String sql = "UPDATE `users` SET `login` = ?, `password` = ?, `first_name` = ?, `last_name` = ?, `role` = ?, `email` = ?, `cash_amount` = ? WHERE `user_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, instance.getLogin());
            statement.setString(2, instance.getPassword());
            statement.setString(3, instance.getFirstName());
            statement.setString(4, instance.getLastName());
            statement.setInt(5, instance.getRole().getId());
            statement.setString(6, instance.getEmail());
            statement.setBigDecimal(7, instance.getCashAmount());
            statement.setInt(8, instance.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            logger.error("Can not update user in db, user login = " + instance.getLogin());
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        String sql = "DELETE FROM `users` WHERE `user_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            logger.error("Can not delete user from db with id = " + id);
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void updateUserCash(Integer userId, BigDecimal newCashAmount) throws PersistentException {
        String sql = "UPDATE `users` SET `cash_amount` = ? WHERE `user_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, newCashAmount);
            statement.setInt(2, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update user's cashAmount for user with id: " + userId);
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }
}
