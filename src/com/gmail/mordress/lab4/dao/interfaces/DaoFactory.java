package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.exceptions.DaoException;

public interface DaoFactory {

    <T extends Dao<?>> T createDao(Class<? extends Dao<?>> key) throws DaoException;

    void close();
}
