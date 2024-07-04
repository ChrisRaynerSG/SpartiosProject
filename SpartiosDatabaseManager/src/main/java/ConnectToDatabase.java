import com.sparta.spartios.DatabaseCreationStatements;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

class ConnectToDatabase {
  public static Connection employeeDatabaseConnection(){
   try {
    Properties properties = openProperties();
    Connection connection = connectionToDB(properties);

   } catch (SQLException | IOException e) {
    //create the database
   }
  }

  private static Properties openProperties() throws IOException {
   Properties properties = new Properties();
   properties.load(new FileReader("src/main/resources/user.properties"));
   return properties;
  }

  private static Connection connectionToDB(Properties properties) throws SQLException {

   return DriverManager.getConnection(
           properties.getProperty("url"),
           properties.getProperty("username"),
           properties.getProperty("password"));

  }





}
