package com.gmail.mordress.lab4.dao.implementation;

import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.dao.interfaces.HorseDao;
import com.gmail.mordress.lab4.domain.Breed;
import com.gmail.mordress.lab4.domain.Horse;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HorseDaoImpl extends BaseDaoImpl implements HorseDao {

    private static Logger logger = Logger.getLogger(HorseDaoImpl.class);


    @Override
    public Horse findByName(String name) throws DaoException {
        return null;
    }

    @Override
    public List<Horse> findHorsesByBreed(Breed instance) throws DaoException {
        String sql = "SELECT * FROM `horse` WHERE `breed_ID` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, instance.getId());
            resultSet = statement.executeQuery();
            List<Horse> horses = new ArrayList<>();
            Horse horse = null;
            while (resultSet.next()) {
                horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horse.setName(resultSet.getString("name"));
                horse.setAge(resultSet.getInt("age"));
                horse.setWeight(resultSet.getInt("weight"));
                Breed breed = new Breed();
                breed.setId(resultSet.getInt("breed_ID"));
                horse.setBreed(breed);
                horses.add(horse);
            }
            logger.debug("Successful find horses by breed = " + instance);
            return horses;

        } catch (SQLException e) {
            logger.debug("Can not find  horses by breed = " + instance);
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
    public List<Horse> getAllHorses() throws DaoException {
        String sql = "SELECT * FROM `horse` ORDER BY `name`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Horse> horses = new ArrayList<>();
            Horse horse = null;
            while (resultSet.next()) {
                horse = new Horse();
                horse.setId(resultSet.getInt("horse_ID"));
                horse.setName(resultSet.getString("name"));
                horse.setAge(resultSet.getInt("age"));
                horse.setWeight(resultSet.getInt("weight"));
                Breed breed = new Breed();
                breed.setId(resultSet.getInt("breed_ID"));
                horse.setBreed(breed);
                horses.add(horse);
            }
            logger.debug("Successful read horses");
            return horses;
        } catch (SQLException e) {
            logger.debug("Can not read all horses");
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
    public Integer create(Horse instance) throws DaoException {
        String sql = "INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES (?, ?, ?, ?)";
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, instance.getName());
            statement.setInt(2, instance.getBreed().getId());
            statement.setInt(3, instance.getWeight());
            statement.setInt(4, instance.getAge());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `horse`");
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
    public Horse read(Integer id) throws DaoException {
        String sql = "SELECT `name`, `breed_ID`, `weight`, `age` FROM `horse` WHERE `horse_ID` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Horse horse = null;
            if (resultSet.next()) {
                horse = new Horse();
                horse.setName(resultSet.getString("name"));
                Breed breed = new Breed();
                breed.setId(resultSet.getInt("breed_ID"));
                horse.setBreed(breed);
                horse.setAge(resultSet.getInt("age"));
                horse.setWeight(resultSet.getInt("weight"));
            }
            return horse;
        } catch (SQLException e) {
            logger.debug("Can not read Horse form db with ID + " + id);
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
    public void update(Horse instance) throws DaoException {
        String sql = "UPDATE `horse` SET `name` = ?, `breed_ID` = ?, `weight` = ?, `age` = ? WHERE `horse_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, instance.getName());
            statement.setInt(2, instance.getBreed().getId());
            statement.setInt(3, instance.getWeight());
            statement.setInt(4, instance.getAge());
            statement.setInt(5, instance.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.debug("Can not update horse with ID = "  + instance.getId());
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        String sql = "DELETE FROM `horse` WHERE `horse_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }
}