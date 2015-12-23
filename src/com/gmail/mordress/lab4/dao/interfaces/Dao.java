package com.gmail.mordress.lab4.dao.interfaces;

import com.gmail.mordress.lab4.exceptions.PersistentException;
import java.io.Serializable;


public interface Dao<T extends Serializable> {

    public Integer create(T instance) throws PersistentException;

    public T read(Integer id) throws PersistentException;

    public void update(T instance) throws PersistentException;

    public void delete(Integer id) throws PersistentException;
}
