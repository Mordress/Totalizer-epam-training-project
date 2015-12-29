package com.gmail.mordress.epamproject.dao.mysql;

import com.gmail.mordress.epamproject.dao.interfaces.HorseRaceDao;
import com.gmail.mordress.epamproject.entities.Horse;
import com.gmail.mordress.epamproject.entities.HorseRace;
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

/**
 * Provides additional operations for results horse and race to interaction with mysql.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class HorseRaceDaoImpl extends BaseDaoImpl implements HorseRaceDao {

    private static Logger logger = Logger.getLogger(HorseRaceDaoImpl.class);

    /** Returns all horseRace instances with same race.
     * @param instance - Race.
     * @return List of HorseRace instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    @Override
    public List<HorseRace> findByRace(Race instance) throws PersistentException {
        String sql = "SELECT * FROM `horse_race` WHERE race_ID = ? ORDER BY `result_rank`";
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
                if (resultSet.getTimestamp("result_time") != null) {
                    horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                } else {
                    horseRace.setResultTime(null);
                }
                Race race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                Horse horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horseRace.setHorse(horse);
                horseRaces.add(horseRace);
            }
            return horseRaces;
        } catch (SQLException e) {
            logger.error("Can not find horseRaces by race with id = " + instance.getId());
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

    /** Returns all horseRace instances with same horse.
     * @param instance - Some horse.
     * @return List of HorseRace instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    @Override
    public List<HorseRace> getHorseRacePerHorse(Horse instance) throws PersistentException {
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
                if (resultSet.getTimestamp("result_time") != null) {
                    horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                } else {
                    horseRace.setResultTime(null);
                }
                Race race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                Horse horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horseRace.setHorse(horse);
                horseRaces.add(horseRace);
            }
            return horseRaces;
        } catch (SQLException e) {
            logger.error("Can not find horseRaces by horse with id = " + instance.getId());
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

    /** Returns all possible instances of horseRaces.
     * @return List of HorseRace instances.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    @Override
    public List<HorseRace> getAllHorseRaces() throws PersistentException {
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
                if (resultSet.getTimestamp("result_time") != null) {
                    horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                } else {
                    horseRace.setResultTime(null);
                }
                Race race = new Race();
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                Horse horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horseRace.setHorse(horse);
                horseRaces.add(horseRace);
            }
            return horseRaces;
        } catch (SQLException e) {
            logger.error("Can not read all horseRaces");
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
    public Integer create(HorseRace instance) throws PersistentException {
        String sql = "INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (?, ?, ?, ?)";
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, instance.getRace().getId());
            statement.setInt(2, instance.getHorse().getId());
            if (instance.getResultRank() != null) {
                statement.setInt(3, instance.getResultRank());
            } else {
                statement.setInt(3, 0);
            }
            if (instance.getResultTime() != null) {
                statement.setTimestamp(4, new java.sql.Timestamp(instance.getResultTime().getTime()));
            } else {
                statement.setTimestamp(4, null);
            }
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `horse_race`");
                throw new PersistentException();
            }
        } catch (SQLException e) {
            throw new PersistentException(e.getMessage(), e.getCause());
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
    public HorseRace read(Integer id) throws PersistentException {
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
                if (resultSet.getTimestamp("result_time") != null) {
                    horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                } else {
                    horseRace.setResultTime(null);
                }
                Horse horse = new Horse();
                Race race = new Race();
                horse.setId(resultSet.getInt("horse_ID"));
                race.setId(resultSet.getInt("race_ID"));
                horseRace.setRace(race);
                horseRace.setHorse(horse);
            }
            return horseRace;
        } catch (SQLException e) {
            logger.error("Can not read HorseRace form db with ID + " + id);
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
    public void update(HorseRace instance) throws PersistentException {
        String sql = "UPDATE `horse_race` SET `race_ID` = ?, `horse_ID` = ?, `result_rank` = ?, `result_time` = ? WHERE `horse_race_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getRace().getId());
            statement.setInt(2, instance.getHorse().getId());
            if (instance.getResultRank() != null) {
                statement.setInt(3, instance.getResultRank());
            } else {
                statement.setInt(3, 0);
            }
            if (instance.getResultTime() != null) {
                statement.setTimestamp(4, new java.sql.Timestamp(instance.getResultTime().getTime()));
            } else {
                statement.setTimestamp(4, null);
            }
            statement.setInt(5, instance.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            logger.error("Can not update HorseRace with id = " + instance.getId());
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        String sql = "DELETE FROM `horse_race` WHERE horse_race_ID = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not delete HorseRace with id = "+ id);
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }

    /** Returns horseRace instance with same race and same horse.
     * @param horseId - Horse instance id.
     * @param raceId - Race instance id.
     * @return horseRace instance.
     * @throws PersistentException - if DBMS can't successful complete this operation. */
    @Override
    public HorseRace findByRaceAndHorse(Integer horseId, Integer raceId) throws PersistentException {
        String sql = "SELECT * FROM `horse_race` WHERE (`horse_ID` = ? AND `race_ID` = ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, horseId);
            statement.setInt(2, raceId);
            resultSet = statement.executeQuery();
            HorseRace horseRace = null;
            if (resultSet.next()) {
                horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                horseRace.setResultRank(resultSet.getInt("result_rank"));
                if (resultSet.getTimestamp("result_time") != null) {
                    horseRace.setResultTime(new Date(resultSet.getTimestamp("result_time").getTime()));
                } else {
                    horseRace.setResultTime(null);
                }
                Horse horse = new Horse();
                Race race = new Race();
                horse.setId(horseId);
                race.setId(raceId);
                horseRace.setRace(race);
                horseRace.setHorse(horse);
            }
            return horseRace;
        } catch (SQLException e) {
            logger.error("Can not find horseRace by raceId: " + raceId + " and horseId: " + horseId);
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
}
