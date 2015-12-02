package com.gmail.mordress.lab4.dao.mysql;

import com.gmail.mordress.lab4.dao.*;
import com.gmail.mordress.lab4.dao.pool.ConnectionPool;
import com.gmail.mordress.lab4.exceptions.PersistentException;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DaoFactoryImpl implements DaoFactory {

    private static Logger logger = Logger.getLogger(DaoFactoryImpl.class);

    private static Map<Class<? extends Dao<?>>, Class<? extends BaseDaoImpl>> classes = new ConcurrentHashMap<>();

    static {
        classes.put(BreedDao.class, BreedDaoImpl.class);
        classes.put(HorseDao.class, HorseDaoImpl.class);
        //TODO OTHER CLASSES
    }

    private Connection connection;

    public DaoFactoryImpl() throws DaoException, PersistentException {
        connection = ConnectionPool.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
        } catch(SQLException e) {
            logger.error("It is impossible to turn off autocommiting for database connection", e);
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Dao<?>> T createDao(Class<T> key) throws DaoException {
        Class<? extends BaseDaoImpl> value = classes.get(key);
        if(value != null) {
            try {
                BaseDaoImpl dao = value.newInstance();
                dao.setConnection(connection);
                return (T)dao;
            } catch(InstantiationException | IllegalAccessException e) {
                logger.error("It is impossible to create DAO", e);
                throw new DaoException(e.getMessage(), e.getCause());
            }
        }
        return null;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch(SQLException e) {}
    }
}
