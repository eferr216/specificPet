package edu.matc.test.util;

import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database implements PropertiesLoader {

    // crate an object of the class Database
    private static Database instance;

    static {
        try {
            instance = new Database();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // create the logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    private Properties properties;

    private Connection connection;

    /**
     * private constructor prevents instantiating this class anywhere else
     */
    private Database() throws Exception {
        //loadProperties();
        properties = loadProperties("/database.properties");
    }

    /*private void loadProperties(String s) {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file", ioe);
        } catch (Exception e) {
            logger.error("Database.loadProperties()...", e);
        }

    }*/

    /**
     * Get the only Database object available
     *
     * @return the single database object
     */
    public static Database getInstance() {
        return instance;
    }

    /**
     * Get the database connection
     *
     * @return the database connection
     */
    public Connection getConnection() {
        return connection;
    }

    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"), properties.getProperty("password"));

    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Cannot close connection", e);
            }
        }

        connection = null;
    }

    /**
     * Run the sql.
     *
     * @param sqlFile the sql file to be read and executed line by line
     */
    public void runSQL(String sqlFile) {

        Statement stmt = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //InputStream inputStream = classloader.getResourceAsStream(sqlFile);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(sqlFile)))) {

            connect();
            stmt = connection.createStatement();

            String sql = "";

            while (br.ready()) {
                char inputValue = (char)br.read();

                if (inputValue == ';') {
                    stmt.executeUpdate(sql);
                    sql = "";
                }
                else {
                    sql += inputValue;
                }

            }

        } catch (SQLException se) {
            logger.error(se);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            disconnect();
        }
    }
}