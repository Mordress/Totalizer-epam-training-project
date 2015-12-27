package com.gmail.mordress.epamproject.dao.mysql;

import com.gmail.mordress.epamproject.dao.interfaces.BreedDao;
import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BreedDaoImpl extends BaseDaoImpl implements BreedDao{

    private static Logger logger = Logger.getLogger(BreedDaoImpl.class);

    @Override
    public Breed findByName(String name) throws PersistentException {
        String sql = "SELECT * FROM `breed` WHERE `name` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            Breed breed = new Breed();
            if (resultSet.next()) {
                breed = new Breed();
                breed.setId(resultSet.getInt("breed_ID"));
                breed.setName(resultSet.getString("name"));
            }
            return breed;
        } catch (SQLException e) {
            logger.error("Can not find breed with name = " + name);
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
    public List<Breed> getAllBreeds() throws PersistentException {
        String sql = "SELECT * FROM `breed` ORDER BY `name`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Breed> breeds = new ArrayList<>();
            Breed breed = null;
            while (resultSet.next()) {
                breed = new Breed();
                breed.setId(resultSet.getInt("breed_ID"));
                breed.setName(resultSet.getString("name"));
                breeds.add(breed);
            }
            return breeds;
        } catch (SQLException e) {
            logger.error("Can not read all breeds");
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
    public Integer create(Breed instance) throws PersistentException {
        String sql = "INSERT INTO `breed` (`name`) VALUES (?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, instance.getName());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `breed`");
                throw new PersistentException();
            }
        } catch (SQLException e) {
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
    public Breed read(Integer id) throws PersistentException {
        String sql = "SELECT `name` FROM `breed` WHERE `breed_ID` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Breed breed = null;
            if (resultSet.next()) {
                breed = new Breed();
                breed.setId(id);
                breed.setName(resultSet.getString("name"));
            }
            return breed;
        } catch (SQLException e) {
            logger.error("Can not read breed with ID = " + id);
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
    public void update(Breed instance) throws PersistentException {
        String sql = "UPDATE `breed` SET `name` = ? WHERE `breed_ID` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, instance.getName());
            statement.setInt(2, instance.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Can not update breed with ID = "  + instance.getId());
            throw new PersistentException(e.getMessage(), e.getCause());
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {}
        }

    }

    @Override
    public void delete(Integer id) throws PersistentException {
        String sql = "DELETE FROM `breed` WHERE `breed_ID` = ?";
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
