package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.exceptions.PersistentException;

public interface DaoFactory {

    <T extends Dao<?>> T createDao(Class<? extends Dao<?>> key) throws PersistentException;

    void close();
}
