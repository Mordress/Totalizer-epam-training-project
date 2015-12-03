package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RaceDaoImpl extends BaseDaoImpl implements RaceDao {

    private static Logger logger = Logger.getLogger(RaceDaoImpl.class);

    @Override
    public List<Race> getPassedRaces() throws DaoException {
        return null;
    }

    @Override
    public List<Race> getFutureRaces() throws DaoException {
        return null;
    }

    @Override
    public Integer create(Race instance) throws DaoException {
        String sql = "INSERT INTO `race` (`date`, `distance`) VALUES (?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, new java.sql.Date(instance.getRaceDate().getTime()));
            statement.setInt(2, instance.getDistance());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `race`");
                throw new DaoException();
            }
        } catch (SQLException e) {
            logger.debug("Can not create race in database");
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }

    @Override
    public Race read(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(Race instance) throws DaoException {

    }

    @Override
    public void delete(Integer id) throws DaoException {

    }
}
