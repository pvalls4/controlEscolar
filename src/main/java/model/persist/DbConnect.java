package model.persist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DbConnect {

    public static final String FILE_PATH = "C:\\Users\\Mati\\Documents\\GitValls\\controlEscolar\\files\\dbConnection.properties";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String PROTOCOL = "jdbc:mysql:";
    public static String HOST;
    public static String BD_NAME;
    public static String USER;
    public static String PASSWORD;
    public static String BD_URL;

    public static void loadDriver() throws ClassNotFoundException {
        getConnectionProperties();
        Class.forName(DRIVER);
        BD_URL = String.format("%s//%s/%s", PROTOCOL, HOST, BD_NAME);
    }

    private static void getConnectionProperties() throws ClassNotFoundException {
        //getConnectionProperties(); better if connection properties are read from a configuration file
        Class.forName(DRIVER);
        BD_URL = String.format("%s//%s/%s", PROTOCOL, HOST, BD_NAME);
    }

    /**
     * gets and returns a connection to database
     *
     * @return connection
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(FILE_PATH));
            HOST = props.getProperty("HOST");
            BD_NAME = props.getProperty("BD_NAME");
            USER = props.getProperty("USER");
            PASSWORD = props.getProperty("PASSWORD");
            BD_URL = String.format("%s//%s/%s", PROTOCOL, HOST, BD_NAME);

            conn = DriverManager.getConnection(BD_URL, USER, PASSWORD);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
