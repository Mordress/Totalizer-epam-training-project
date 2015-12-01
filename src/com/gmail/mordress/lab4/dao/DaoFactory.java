package com.gmail.mordress.lab4.dao;

public interface DaoFactory {

    <T extends Dao<?>> T createDao(Class<T> key) throws DaoException;

    void close();
}
