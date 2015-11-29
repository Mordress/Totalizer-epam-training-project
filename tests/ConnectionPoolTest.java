
import com.gmail.mordress.lab4.dao.pool.ConnectionPool;
import com.gmail.mordress.lab4.exceptions.PersistentException;

import java.sql.Connection;

public class ConnectionPoolTest {

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try {
            pool.init();
            Connection connection = pool.getConnection();
        } catch (PersistentException e) {
            e.printStackTrace();
        }

    }
}
