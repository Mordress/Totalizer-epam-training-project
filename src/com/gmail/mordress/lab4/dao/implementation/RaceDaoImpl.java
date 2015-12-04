package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.RaceDao;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RaceDaoImpl extends BaseDaoImpl implements RaceDao {

    private static Logger logger = Logger.getLogger(RaceDaoImpl.class);

    @Override
    public List<Race> getPassedRaces() throws DaoException {
        String sql = "SELECT * FROM `race` WHERE date < ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
            resultSet = statement.executeQuery();
            List<Race> races = new ArrayList<>();
            Race race = null;
            while (resultSet.next()) {
                race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                race.setDistance(resultSet.getInt("distance"));
                race.setRaceDate(new Date(resultSet.getTimestamp("date").getTime()));
                races.add(race);
            }
            return races;

        } catch (SQLException e) {
            logger.debug("Can not read passed races");
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
    public List<Race> getFutureRaces() throws DaoException {
        String sql = "SELECT * FROM `race` WHERE date > ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
            resultSet = statement.executeQuery();
            List<Race> races = new ArrayList<>();
            Race race = null;
            while (resultSet.next()) {
                race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                race.setDistance(resultSet.getInt("distance"));
                race.setRaceDate(new Date(resultSet.getTimestamp("date").getTime()));
                races.add(race);
            }
            return races;

        } catch (SQLException e) {
            logger.debug("Can not read future races");
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
    public Integer create(Race instance) throws DaoException {
        String sql = "INSERT INTO `race` (`date`, `distance`) VALUES (?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, new java.sql.Timestamp(instance.getRaceDate().getTime()));
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
        String sql = "SELECT * FROM `race` WHERE `race_ID` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Race race = null;
            if (resultSet.next()) {
                race = new Race();
                race.setId(id);
                race.setRaceDate(new Date(resultSet.getTimestamp("date").getTime()));
                race.setDistance(resultSet.getInt("distance"));
            }
            return race;
        } catch (SQLException e) {
            logger.error("Can not read race with id = " + id + " from db");
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
    public void update(Race instance) throws DaoException {
        String sql = "UPDATE `race` SET `date` = ?, `distance` = ? WHERE `race_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(instance.getRaceDate().getTime()));
            statement.setInt(2, instance.getDistance());
            statement.setInt(3, instance.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.debug("Can not update race with ID = "  + instance.getId());
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }

    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sql = "DELETE FROM `race` WHERE `race_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            logger.debug("Can not delete breed with ID = " + id);
            throw new DaoException(e.getMessage(), e.getCause());
        }finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }
}
