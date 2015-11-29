package com.gmail.mordress.lab4.dao.pool;

import com.gmail.mordress.lab4.exceptions.PersistentException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

final public class ConnectionPool {

    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    private String url;

    private String user;

    private String password;

    private int maxSize;

    private int checkConnectionTimeout;

    private BlockingQueue<PooledConnection> freeConnections = new LinkedBlockingQueue<>();

    Set<PooledConnection> usedConnections = new ConcurrentSkipListSet<>();

    private ConnectionPool() {};

    /*public synchronized Connection getConnection() throws PersistentException {
        PooledConnection connection = null;
        while (connection == null) {
            try{
                if (!freeConnections.isEmpty()) {
                    connection = freeConnections.take();
                    if (!connection.isValid(checkConnectionTimeout)) {
                        try {
                            connection.getConnection().close;
                        }
                    }
                }
            }
        }
    }*/


}
