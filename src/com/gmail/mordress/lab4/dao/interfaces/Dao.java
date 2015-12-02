package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.exceptions.DaoException;

import java.io.Serializable;


public interface Dao<T extends Serializable> {

    public Integer create(T instance) throws DaoException;

    public T read(Integer id) throws DaoException;

    public void update(T instance) throws DaoException;

    public void delete(Integer id) throws DaoException;
}
