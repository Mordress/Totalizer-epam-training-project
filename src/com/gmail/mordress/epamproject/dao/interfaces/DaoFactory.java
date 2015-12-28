package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.exceptions.PersistentException;

/**
 * Provides access to DAO-classes for interact with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface DaoFactory {

    /** Returns distinct DAO implementation for distinct DAO interface.
     * @param key - Distinct DAO interface.
     * @return Distinct DAO implementation.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    <T extends Dao<?>> T createDao(Class<? extends Dao<?>> key) throws PersistentException;

    /** Free system resourses. */
    void close();
}
