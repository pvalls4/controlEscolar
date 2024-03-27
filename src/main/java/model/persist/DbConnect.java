package model.persist;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DbConnect {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String PROTOCOL = "jdbc:mysql:";
    public static String HOST = "localhost";
    public static String BD_NAME = "bd_institucion";
    public static String USER = "root";
    public static String PASSWORD = "123456";
    public static String BD_URL;


    /**
     * gets and returns a connection to database
     *
     * @return connection
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        BD_URL = String.format("%s//%s/%s?autoReconnect=true&useSSL=false", PROTOCOL, HOST, BD_NAME);
        
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
