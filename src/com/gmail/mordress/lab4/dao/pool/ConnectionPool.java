package com.gmail.mordress.lab4.dao.pool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.gmail.mordress.lab4.exceptions.PersistentException;
import org.apache.log4j.Logger;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;

public final class ConnectionPool {

    private static ConnectionPool instance = new ConnectionPool();

    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    private String driverClass;

    private String dbURL;

    private String dbUser;

    private String dbPassword;

    private int maxPoolSize;

    private int checkConnectionTimeout;

    private BlockingQueue<PooledConnection> freeConnections = new LinkedBlockingQueue<>();

    private Set<PooledConnection> usedConnections = new ConcurrentSkipListSet<>();

    private ConnectionPool() {};

    public static ConnectionPool getInstance() {
        return instance;
    }

    public synchronized void init() throws PersistentException {
        try {
            destroy();
            FileInputStream fileInputStream = new FileInputStream("resources" + File.separator + "db.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);

            Class.forName(driverClass);
            this.url = url;
            this.user = user;
            this.password = password;
            this.maxSize = maxSize;
            this.checkConnectionTimeout = checkConnectionTimeout;
            for(int counter = 0; counter < startSize; counter++) {
                freeConnections.put(createConnection());
            }
        } catch (IOException e) {
            logger.fatal("File db.properties not found.", e);
            throw new PersistentException();
        } catch(ClassNotFoundException | SQLException | InterruptedException e) {
            logger.fatal("Can't initialize db connection pool.", e);
            throw new PersistentException();
        }
    }

    public synchronized Connection getConnection() throws ConnectionException {

    }


}
