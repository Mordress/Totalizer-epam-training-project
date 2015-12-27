package pool;

import com.gmail.mordress.epamproject.dao.pool.ConnectionPool;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            Connection con1 = pool.getConnection();
            Connection con2 = pool.getConnection();
            Connection con3 = pool.getConnection();
            Connection con4 = pool.getConnection();
            Connection con5 = pool.getConnection();
            Connection con6 = pool.getConnection();
            Connection con7 = pool.getConnection();
            Connection con8 = pool.getConnection();
            Connection con9 = pool.getConnection();
            Connection con10 = pool.getConnection();
            Connection con11 = pool.getConnection();
            Connection con12 = pool.getConnection();
            Connection con13 = pool.getConnection();
            Connection con14 = pool.getConnection();
            con1.close();
            con2.close();
            con3.close();
            con4.close();
            con5.close();
            con6.close();
            con7.close();
            con8.close();
            con9.close();
            con10.close();
            con11.close();
            con12.close();
            con13.close();
            con14.close();
        } catch (PersistentException | SQLException e) {
            e.printStackTrace();
        }
    }
}
