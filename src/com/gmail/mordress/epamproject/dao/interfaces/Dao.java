package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.io.Serializable;

/**
 * Provides basic CRUD operations for interaction entities with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface Dao<T extends Serializable> {

    /** Create in db entity instance.
     * @param instance - generic instance of some entity.
     * @return id of created entity.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public Integer create(T instance) throws PersistentException;

    /** Read from db entity instance.
     * @param id - generic instance id of some entity.
     * @return generic instance of readed entity.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public T read(Integer id) throws PersistentException;

    /** Update db record with new entity instance.
     * @param instance - generic instance of some entity.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public void update(T instance) throws PersistentException;

    /** Delete db record with entity instance.
     * @param id - generic instance id of some entity.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    public void delete(Integer id) throws PersistentException;
}
