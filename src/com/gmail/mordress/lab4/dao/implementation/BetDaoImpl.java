package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.BetDao;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.HorseRace;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BetDaoImpl extends BaseDaoImpl implements BetDao {

    private static Logger logger = Logger.getLogger(BetDaoImpl.class);

    @Override
    public List<Bet> findAllBetsByUser(User instance) throws DaoException {
        String sql = "SELECT * FROM `bet` WHERE `user_ID` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getId());
            resultSet = statement.executeQuery();
            List<Bet> bets = new ArrayList<>();
            Bet bet = null;
            while (resultSet.next()) {
                bet = new Bet();
                bet.setId(resultSet.getInt("bet_ID"));
                bet.setResultRank(resultSet.getInt("result_rank"));
                bet.setResultTime(new Date(resultSet.getTime("result_time").getTime()));
                bet.setBetAmount(resultSet.getBigDecimal("bet_amount"));
                bet.setWinAmount(resultSet.getBigDecimal("win_amount"));
                bet.setIsWinner(resultSet.getBoolean("is_winner"));
                bet.setUser(instance);
                HorseRace horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                bet.setHorseRace(horseRace);
                bet.setCreatedDate(new Date(resultSet.getTimestamp("created_date").getTime()));
                bets.add(bet);
            }
            return bets;
        } catch (SQLException e) {
            logger.debug("Can not find winned users by user with id = " + instance.getId());
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
    public List<Bet> findWinnedBets() throws DaoException {
        String sql = "SELECT * FROM `bet` WHERE `is_winner` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, new Boolean(true));
            resultSet = statement.executeQuery();
            List<Bet> bets = new ArrayList<>();
            Bet bet = null;
            while (resultSet.next()) {
                bet = new Bet();
                bet.setId(resultSet.getInt("bet_ID"));
                bet.setResultRank(resultSet.getInt("result_rank"));
                bet.setResultTime(new Date(resultSet.getTime("result_time").getTime()));
                bet.setBetAmount(resultSet.getBigDecimal("bet_amount"));
                bet.setWinAmount(resultSet.getBigDecimal("win_amount"));
                bet.setIsWinner(resultSet.getBoolean("is_winner"));
                User user = new User();
                user.setId(resultSet.getInt("user_ID"));
                bet.setUser(user);
                HorseRace horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                bet.setHorseRace(horseRace);
                bet.setCreatedDate(new Date(resultSet.getTimestamp("created_date").getTime()));
                bets.add(bet);
            }
            return bets;
        } catch (SQLException e) {
            logger.debug("Can not find winned bets.");
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
    public List<Bet> findWinnedBetsByUser(User instance) throws DaoException {
        String sql = "SELECT * FROM `bet` WHERE (`user_ID` = ? AND `is_winner` = ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getId());
            statement.setBoolean(2, new Boolean(true));
            resultSet = statement.executeQuery();
            List<Bet> bets = new ArrayList<>();
            Bet bet = null;
            while (resultSet.next()) {
                bet = new Bet();
                bet.setId(resultSet.getInt("bet_ID"));
                bet.setResultRank(resultSet.getInt("result_rank"));
                bet.setResultTime(new Date(resultSet.getTime("result_time").getTime()));
                bet.setBetAmount(resultSet.getBigDecimal("bet_amount"));
                bet.setWinAmount(resultSet.getBigDecimal("win_amount"));
                bet.setIsWinner(resultSet.getBoolean("is_winner"));
                bet.setUser(instance);
                HorseRace horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                bet.setHorseRace(horseRace);
                bet.setCreatedDate(new Date(resultSet.getTimestamp("created_date").getTime()));
                bets.add(bet);
            }
            return bets;
        } catch (SQLException e) {
            logger.debug("Can not find winned users by user with id = " + instance.getId());
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
    public Integer create(Bet instance) throws DaoException {
        String sql = "INSERT INTO `bet` (`horse_race_ID`, `result_rank`, `result_time`, `bet_amount`, `win_amount`," +
                " `is_winner`, `user_ID`, `created_date`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, instance.getId());
            statement.setInt(2, instance.getResultRank());
            statement.setTime(3, new java.sql.Time(instance.getResultTime().getTime()));
            statement.setBigDecimal(4, instance.getBetAmount());
            statement.setBigDecimal(5, instance.getWinAmount());
            statement.setBoolean(6, instance.getIsWinner());
            statement.setInt(7, instance.getUser().getId());
            statement.setTimestamp(8, new java.sql.Timestamp(instance.getCreatedDate().getTime()));
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                logger.debug("Bet with id = " + instance.getId() + " successfully created!");
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `bets`");
                throw new DaoException();
            }
        } catch (SQLException e) {
            logger.error("Can not create bet with id = " + instance.getId());
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
    public Bet read(Integer id) throws DaoException {
        String sql = "SELECT  * FROM `bet` WHERE `bet_ID` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Bet bet = null;
            if (resultSet.next()) {
                bet = new Bet();
                HorseRace horseRace = new HorseRace();
                horseRace.setId(resultSet.getInt("horse_race_ID"));
                bet.setHorseRace(horseRace);
                bet.setResultRank(resultSet.getInt("result_rank"));
                bet.setResultTime(new Date(resultSet.getTime("result_time").getTime()));
                bet.setIsWinner(resultSet.getBoolean("is_winner"));
                bet.setBetAmount(resultSet.getBigDecimal("bet_amount"));
                bet.setWinAmount(resultSet.getBigDecimal("win_amount"));
                User user = new User();
                user.setId(resultSet.getInt("user_ID"));
                bet.setUser(user);
            }
            logger.debug("Successfull reading bet with id = " + id);
            return bet;
        } catch (SQLException e) {
            logger.error("Can not read bet with id = " + id);
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
    public void update(Bet instance) throws DaoException {
        String sql = "UPDATE `bet` SET `horse_race_ID` = ?, `result_rank` = ?, `result_time` = ?, `bet_amount` = ?, " +
                "`win_amount` = ?, `is_winner` = ?, `created_date` = ?, `user_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getHorseRace().getId());
            statement.setInt(2, instance.getResultRank());
            statement.setTime(3, new java.sql.Time(instance.getResultTime().getTime()));
            statement.setBigDecimal(4, instance.getBetAmount());
            statement.setBigDecimal(5, instance.getWinAmount());
            statement.setBoolean(6, instance.getIsWinner());
            statement.setTimestamp(7, new java.sql.Timestamp(instance.getCreatedDate().getTime()));
            statement.setInt(8, instance.getUser().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.debug("Can not update bet with id = " + instance.getId());
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sql = "DELETE FROM `bet` WHERE `bet_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.debug("Can not delete bet with ID = " + id);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }
}
