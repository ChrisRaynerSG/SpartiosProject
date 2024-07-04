import com.sparta.spartios.DatabaseCreationStatements;
import com.sparta.spartios.dtos.Employee;
import com.sparta.spartios.filereader.CsvReader;

import java.sql.*;
import java.util.HashSet;

import static com.sparta.spartios.App.logger;


// KAT -- Checks if DB exists
// Connect to DB (Local)
// IF NOT
// Requests HashSet -- HashSet hashSet = new HashSet(getAllLines());
// Creates Database

public class DatabaseInitialiser {

    if (!doesDatabaseExist){
        //set up database
    } else {
        //do nothing
    }
    HashSet<Employee> allEmployees = CsvReader.getAllLines();
    //loop prepared statement with getAllLines() HashSet
    // Pass in each line of Hashset, assign each part to ? -- Employee.ID(),Employee.FirstName()
    // Loop for each line
    // Stop when reach length of HashSet


    private static ResultSet createDatabase(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeQuery(DatabaseCreationStatements.createDatabase);
        statement.executeQuery(DatabaseCreationStatements.createTable);

    }

    private static ResultSet importEmployeeEntries(Connection connection, HashSet<Employee> allEmployees) throws SQLException {
        PreparedStatement databaseEntries = connection.prepareStatement(DatabaseCreationStatements.importData);
        for(Employee employee: allEmployees){
            databaseEntries.setString(1,employee.employeeID());
            databaseEntries.setString(2,employee.prefix());
            databaseEntries.setString(3,employee.firstName());
            databaseEntries.setString(4,employee.middleInitial());
            databaseEntries.setString(5,employee.lastName());
            databaseEntries.setString(6,employee.gender());
            databaseEntries.setString(7,employee.email());
            databaseEntries.setString(8,employee.dateOfBirth());
            databaseEntries.setString(9,employee.dateOfJoining());
            databaseEntries.setString(10,employee.salary());
            databaseEntries.executeQuery();
        }
        

        return ;

    }



    public static boolean doesDatabaseExist(){
        // check if file exists
        return true;
    }


}
