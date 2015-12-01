package com.gmail.mordress.lab4.dao;

import java.io.Serializable;
import java.sql.SQLException;


public interface Dao<T extends Serializable> {

    public Integer create(T instance) throws DaoException;

    public T read(Integer id) throws DaoException;

    public void update(T instance) throws DaoException;

    public void delete(Integer id) throws DaoException;
}
