package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.math.BigDecimal;
import java.util.List;

public interface UserDao extends Dao<User> {

    public User findUser(String login, String password) throws PersistentException;

    public boolean checkUniqueLogin(String login) throws PersistentException;

    public List<User> getAllSimpleUsers() throws PersistentException;

    public void updateUserCash(Integer userId, BigDecimal newCashAmount) throws PersistentException;

}
