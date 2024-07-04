package com.sparta.spartios;

import com.sparta.spartios.dtos.Employee;
import com.sparta.spartios.filereader.CsvReader;

import java.sql.*;
import java.util.HashSet;

import static com.sparta.spartios.App.logger;


public class DatabaseInitialiser {

    public static void instantiateDatabase(Connection connection){
        HashSet<Employee> allEmployees = CsvReader.getAllLines();
        createDatabase(connection);
        assert allEmployees != null;
        importEmployeeEntries(connection, allEmployees);
    }


    private static void createDatabase(Connection connection)  {

        try (Statement statement = connection.createStatement();){
            statement.execute(DatabaseCreationStatements.createDatabase);
            logger.info("Database created");
        } catch (SQLException e) {
            logger.warning("Database failed to instantiate: "+e);
        }
        try (Statement statement = connection.createStatement();){
            statement.execute(DatabaseCreationStatements.createTable);
            logger.info("Database table created");
        } catch (SQLException e){
            logger.warning("Table failed to create: "+e);
        }


    }

    private static void importEmployeeEntries(Connection connection, HashSet<Employee> allEmployees) {

        try (PreparedStatement databaseEntries = connection.prepareStatement(DatabaseCreationStatements.importData);){
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
                databaseEntries.execute();
            }

            logger.info("Database successfully populated");
        } catch (SQLException e) {
            logger.warning("Database failed to populate: "+e);
        }
    }


}
