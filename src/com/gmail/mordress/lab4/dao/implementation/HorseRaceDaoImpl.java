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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HorseRaceDaoImpl extends BaseDaoImpl implements HorseRaceDao {

    private static Logger logger = Logger.getLogger(HorseRaceDaoImpl.class);

    @Override
    public List<HorseRace> findByRace(Race instance) throws DaoException {
        String sql = "SELECT * FROM `horse_race` WHERE race_ID = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getId());
            resultSet = statement.executeQuery();
            List<HorseRace> horseRaces = new ArrayList<>();
            HorseRace horseRace = null;
            while (resultSet.next()) {
                horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                horseRace.setResultRank(resultSet.getInt("result_rank"));
                horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                Race race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                Horse horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horseRace.setHorse(horse);
                horseRaces.add(horseRace);
            }
            logger.debug("Successful read horseRaces by race with id = " + instance.getId());
            return horseRaces;
        } catch (SQLException e) {
            logger.debug("Can not read  horseRaces by race with id = " + instance.getId());
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
    public List<HorseRace> getStatisticPerHorse(Horse instance) throws DaoException {
        String sql = "SELECT * FROM `horse_race` WHERE horse_ID = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getId());
            resultSet = statement.executeQuery();
            List<HorseRace> horseRaces = new ArrayList<>();
            HorseRace horseRace = null;
            while (resultSet.next()) {
                horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                horseRace.setResultRank(resultSet.getInt("result_rank"));
                horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                Race race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                Horse horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horseRace.setHorse(horse);
                horseRaces.add(horseRace);
            }
            logger.debug("Successful read horseRaces with id = " + instance.getId());
            return horseRaces;
        } catch (SQLException e) {
            logger.debug("Can not read  horseRaces by horse with id = " + instance.getId());
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
    public List<HorseRace> getAllHorseRaces() throws DaoException {
        String sql = "SELECT * FROM `horse_race`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<HorseRace> horseRaces = new ArrayList<>();
            HorseRace horseRace = null;
            while (resultSet.next()) {
                horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                horseRace.setResultRank(resultSet.getInt("result_rank"));
                horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                Race race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                Horse horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horseRace.setHorse(horse);
                horseRaces.add(horseRace);
            }
            logger.debug("Successful read horseRaces");
            return horseRaces;
        } catch (SQLException e) {
            logger.debug("Can not read all horseRaces");
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
    public Integer create(HorseRace instance) throws DaoException {
        String sql = "INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (?, ?, ?, ?)";
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, instance.getRace().getId());
            statement.setInt(2, instance.getHorse().getId());
            statement.setInt(3, instance.getResultRank());
            statement.setTime(4, new java.sql.Time(instance.getResultTime().getTime()));
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
        String sql = "SELECT * FROM `horse_race` WHERE `horse_race_ID` = ?";
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
                horseRace.setResultTime(new java.sql.Time(resultSet.getTime("result_time").getTime()));
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
        String sql = "UPDATE `horse_race` SET `race_ID` = ?, `horse_ID` = ?, `result_rank` = ?, `result_time` = ? WHERE `horse_race_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getRace().getId());
            statement.setInt(2, instance.getHorse().getId());
            statement.setInt(3, instance.getResultRank());
            statement.setTime(4, new java.sql.Time(instance.getResultTime().getTime()));
            statement.setInt(5, instance.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            logger.error("Can not update HorseRace with id = " + instance.getId());
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sql = "DELETE FROM `horse_race` WHERE horse_race_ID = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not delete HorseRace with id = "+ id);
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }
}
