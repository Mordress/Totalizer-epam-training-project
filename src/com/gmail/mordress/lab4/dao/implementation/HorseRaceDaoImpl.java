package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.HorseRaceDao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.Race;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class HorseRaceDaoImpl extends BaseDaoImpl implements HorseRaceDao {

    private static Logger logger = Logger.getLogger(HorseRaceDaoImpl.class);

    @Override
    public HorseRace findByHorse(Horse horse) throws DaoException {
        return null;
    }

    @Override
    public HorseRace findByRace(Race race) throws DaoException {
        return null;
    }

    @Override
    public List<HorseRace> getAllHorseRacesByHorse(Horse horse) throws DaoException {
        return null;
    }

    @Override
    public List<HorseRace> getAllHorseRaces() throws DaoException {
        return null;
    }

    @Override
    public Integer create(HorseRace instance) throws DaoException {
        String sql = "INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (?, ?, ?, ?)";
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, instance.getRace().getId());
            statement.setInt(2, instance.getHorse().getId());
            statement.setInt(3, instance.getResultRank());
            statement.setTimestamp(4, new java.sql.Timestamp(instance.getResultTime().getTime()));
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `horse_race`");
                throw new DaoException();
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public HorseRace read(Integer id) throws DaoException {
        String sql = "SELECT * FROM `horse_race` WHERE `horserace_ID` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            HorseRace horseRace = null;
            if (resultSet.next()) {
                horseRace = new HorseRace();
                horseRace.setId(id);
                horseRace.setResultRank(resultSet.getInt("result_rank"));
                horseRace.setResultTime(new java.sql.Timestamp(resultSet.getTimestamp("result_time").getTime()));
                Horse horse = new Horse();
                Race race = new Race();
                horse.setId(resultSet.getInt("horse_ID"));
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                horseRace.setHorse(horse);
            }
            return horseRace;
        } catch (SQLException e) {
            logger.debug("Can not read HorseRace form db with ID + " + id);
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
    public void update(HorseRace instance) throws DaoException {
        String sql = "UPDATE `horse_race` SET `race_ID` = ?, `horse_ID` = ?, `result_rank` = ?, `result_time` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getIdentity());
            statement.setInt(4, user.getIdentity());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }
    }

    @Override
    public void delete(Integer id) throws DaoException {

    }
}
