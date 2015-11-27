package com.gmail.mordress.lab4.dao;

import com.gmail.mordress.lab4.exceptions.PersistentException;
import java.io.Serializable;


public interface Dao<T, PK extends Serializable> {

    PK create(T instance) throws PersistentException;

    T read(PK id) throws PersistentException;

    void update(T instance) throws PersistentException;

    void delete(PK id) throws PersistentException;
}
