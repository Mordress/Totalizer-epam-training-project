package com.gmail.mordress.epamproject.dao.interfaces;

import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.io.Serializable;

/**
 * Provides basic CRUD operations for interaction entities with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface Dao<T extends Serializable> {

    public Integer create(T instance) throws PersistentException;

    public T read(Integer id) throws PersistentException;

    public void update(T instance) throws PersistentException;

    public void delete(Integer id) throws PersistentException;
}
