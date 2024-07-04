package com.sparta.spartios.dbmanagement;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static com.sparta.spartios.App.logger;

public class ConnectToDatabase {
  public static Connection employeeDatabaseConnection(){
      Properties properties = openProperties();
      return connectionToDB(properties);
  }

  private static Properties openProperties() {
   Properties properties = new Properties();
      try {
          properties.load(new FileReader("src/main/resources/user.properties"));
      } catch (IOException e) {
          logger.warning("user.properties does not exist. Please create the file in resources");
      }
      return properties;
  }

  private static Connection connectionToDB(Properties properties)  {
      try {
          logger.info("Attempting to connect to Database employee");
          Connection connection = DriverManager.getConnection(
                  properties.getProperty("url"),
                  properties.getProperty("username"),
                  properties.getProperty("password"));
          logger.info("Database Connection established");
          return connection;
      } catch (SQLException e) {
          logger.warning("Failed to connect to database: "+e+"\n Trying to connect to local machine");
          Connection connection = createDB(properties);
          if (connection != null){
              return connection;
          }

      }
        return null;
  }
    private static Connection createDB(Properties properties){
            Connection connection = connectToLocal(properties);

            try (Statement statement = connection.createStatement();){
                statement.execute(DatabaseCreationStatements.createDatabase);
                logger.info("Database employee created at "+properties.getProperty("url"));
                logger.info("Connecting to new database");
                connection = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password"));
                logger.info("Database Connection established");
                return connection;
            } catch (SQLException ex) {
                logger.warning("Database failed to instantiate: "+ex);
                return null;
            }
    }
    private static Connection connectToLocal(Properties properties){
        try {
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/",
                properties.getProperty("username"),
                properties.getProperty("password"));
            logger.info("Successfully connected to local machine");
            return connection;
         } catch (SQLException ex) {
            logger.warning("Failed to connect to local machine: "+ex);
            return null;
        }

    }




}
