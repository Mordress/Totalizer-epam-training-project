package dao.pool;

import org.apache.log4j.Logger;

final public class ConnectionPool {

    private static Logger logger = Logger.getLogger(ConnectionPool.class);
    private String url;
    private String user;
    private String password;
    private int maxSize;
    private int checkConnectionTimeout;


}
