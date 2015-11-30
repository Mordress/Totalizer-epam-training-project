import com.gmail.mordress.lab4.dao.pool.ConnectionPool;
import java.sql.Connection;

public class ConnectionPoolTest {

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            pool.init();
            Connection connection = pool.getConnection();
            connection.close();
            Connection con1 = pool.getConnection();
            Connection con2 = pool.getConnection();
            Connection con3 = pool.getConnection();
            pool.destroy();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
