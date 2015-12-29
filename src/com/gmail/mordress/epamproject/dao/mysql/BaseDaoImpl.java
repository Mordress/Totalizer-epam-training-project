package com.gmail.mordress.epamproject.dao.mysql;

import java.sql.Connection;

/**
 * Provides basic operations and resources for interaction entities with db.
 * @author Alexey Kardychko
 * @version 1.0
 */
public abstract class BaseDaoImpl {

    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
