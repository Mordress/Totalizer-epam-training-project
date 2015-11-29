package com.gmail.mordress.lab4.dao;

import java.io.Serializable;
import java.sql.SQLException;


public interface Dao<T extends Serializable> {

    public Integer create(T instance) throws SQLException;

    public T read(Integer id) throws SQLException;

    public void update(T instance) throws SQLException;

    public void delete(Integer id) throws SQLException;
}
