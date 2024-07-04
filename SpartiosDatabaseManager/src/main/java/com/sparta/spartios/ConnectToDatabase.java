package com.sparta.spartios;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static com.sparta.spartios.App.logger;

class ConnectToDatabase {
  public static Connection employeeDatabaseConnection(){
   try {
    Properties properties = openProperties();
       return connectionToDB(properties);
   } catch (IOException e) {
       logger.warning("Failed to connect to database: "+e);
   }

   return null;
  }

  private static Properties openProperties() throws IOException {
   Properties properties = new Properties();
   properties.load(new FileReader("src/main/resources/user.properties"));
   return properties;
  }

  private static Connection connectionToDB(Properties properties)  {
      try {
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
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/",
                    properties.getProperty("username"),
                    properties.getProperty("password"));
            logger.info("Successfully connected to local machine");
            try (Statement statement = connection.createStatement();){
                statement.execute(DatabaseCreationStatements.createDatabase);
                logger.info("Database created");
            } catch (SQLException ex) {
                logger.warning("Database failed to instantiate: "+ex);
            }
            return connection;
        } catch (SQLException ex) {
            logger.warning("Failed to connect to local machine: "+ex);
        }
        return null;
    }





}
