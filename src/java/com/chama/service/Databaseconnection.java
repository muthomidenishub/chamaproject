package com.chama.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.sun.xml.internal.fastinfoset.sax.Properties;

public class Databaseconnection {
	
	// init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/chama";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "simple";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
   // private Properties properties;

    // create properties
//    private Properties getProperties() {
//        if (properties == null) {
//            properties = new Properties();
//            properties.setProperty("user", USERNAME);
//            properties.setProperty("password", PASSWORD);
//            properties.setProperty("MaxPooledStatements", MAX_POOL);
//        }
//        return properties;
//    }
 

    // connect database
    public Connection connect() throws SQLException {
    	   //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                System.out.println("Driver Loaded");
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,PASSWORD);
                System.out.println("Connection is successful");
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
            }
        }
    }

}
