package org.example.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    /**
     * Problem: We are creating a connection to our db each time
     * We want to interact with a different table
     * <p>
     * Implementation : Single Design Pattern -> a pattern to ensure that only one instance can exist
     * <p>
     * //One static method that we can call in any other class that we'll need our connection
     * //One static variable that is set to be the connection we return
     * //Make it final to let it be known that the variable should not change
     * <p>
     * 1 - Make sure that we cannot make a new ConnectionManager : by creating a private constructor
     * 2 - We need to check to see if the connection was already made
     * If so we want to make a connection, instead we'll return the existing one
     * <p>
     * We want to add a properties instance to load our credentials from a separate file
     * <p>
     * We want to protect our credentials so we will add them to a jdbc.properties file
     * then add our property files to our .gitignore
     **/

    private static Connection conn;
    private static Properties properties;

    //We are creating a private constructor
    private ConnectionManager() {

    }

    //Create my connection

    public static Connection getConnection() throws SQLException {

        if(properties == null) {
            properties = loadProperties();
        }

        if(conn == null || conn.isClosed()){
            conn = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        }
        System.out.println(conn.getSchema());
        return conn;
    }



    //This method is finding my properties file and returning it to me
    private static Properties loadProperties() {

        Properties properties = new Properties();

        try {


            FileInputStream fileInputStream = new FileInputStream("src/main/resources/jdbc.properties");
            properties.load(fileInputStream);

        }catch (IOException fnfException){
            System.out.println(fnfException.getMessage());
        }
        return properties;
    }
}
