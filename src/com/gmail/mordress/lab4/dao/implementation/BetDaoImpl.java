package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.dao.interfaces.BetDao;
import com.gmail.mordress.lab4.domain.Bet;
import com.gmail.mordress.lab4.domain.User;
import com.gmail.mordress.lab4.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BetDaoImpl extends BaseDaoImpl implements BetDao {

    private static Logger logger = Logger.getLogger(BetDaoImpl.class);


    @Override
    public List<Bet> findAllBetsByUser(User user) throws DaoException {
        return null;
    }

    @Override
    public List<Bet> findWinnedBets() throws DaoException {
        return null;
    }

    @Override
    public List<Bet> findWinnedBetsByUser(User user) throws DaoException {
        return null;
    }

    @Override
    public boolean isBetPassed(Bet bet) {
        return false;
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

        } catch (SQLException e) {

        }
    }

    @Override
    public Bet read(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void update(Bet instance) throws DaoException {

    }

    @Override
    public void delete(Integer id) throws DaoException {

    }
}
