package com.gmail.mordress.epamproject.dao.mysql;

import com.gmail.mordress.epamproject.dao.interfaces.RaceDao;
import com.gmail.mordress.epamproject.entities.Race;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
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
    public List<Race> getPassedRaces() throws PersistentException {
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
            logger.error("Can not read passed races");
            throw new PersistentException(e.getMessage(), e.getCause());
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
    public List<Race> getFutureRaces() throws PersistentException {
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
            logger.error("Can not read future races");
            throw new PersistentException(e.getMessage(), e.getCause());
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
    public Integer create(Race instance) throws PersistentException {
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
                throw new PersistentException();
            }
        } catch (SQLException e) {
            logger.error("Can not create race in database");
            throw new PersistentException(e.getMessage(), e.getCause());
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
    public Race read(Integer id) throws PersistentException {
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
            throw new PersistentException(e.getMessage(), e.getCause());
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
    public void update(Race instance) throws PersistentException {
        String sql = "UPDATE `race` SET `date` = ?, `distance` = ? WHERE `race_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(instance.getRaceDate().getTime()));
            statement.setInt(2, instance.getDistance());
            statement.setInt(3, instance.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update race with ID = "  + instance.getId());
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }

    }

    @Override
    public void delete(Integer id) throws PersistentException {
        String sql = "DELETE FROM `race` WHERE `race_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            logger.error("Can not delete breed with ID = " + id);
            throw new PersistentException(e.getMessage(), e.getCause());
        }finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }
}
