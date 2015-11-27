package com.gmail.mordress.lab4.dao;

import java.io.Serializable;

public interface Dao<T, PK extends Serializable> {

    PK create(T instance);

    T read(PK id);

    void update(T instance);

    void delete(PK id);
}
