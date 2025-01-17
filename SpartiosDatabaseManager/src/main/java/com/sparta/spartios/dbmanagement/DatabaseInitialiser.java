package com.sparta.spartios.dbmanagement;

import com.sparta.spartios.dtos.Employee;
import com.sparta.spartios.filereader.CsvReader;

import java.sql.*;
import java.util.HashSet;

import static com.sparta.spartios.App.logger;


public class DatabaseInitialiser {

    public static void instantiateDatabase(Connection connection, boolean dropOldTable){
        HashSet<Employee> allEmployees = CsvReader.getAllLines();
        if (dropOldTable){
            dropOldTable(connection);
        }
        createTable(connection);
        assert allEmployees != null;
        importEmployeeEntries(connection, allEmployees);
    }


    private static void createTable(Connection connection)  {

        try (Statement statement = connection.createStatement();){
            logger.info("Attempting to create table");
            statement.execute(Queryable.CREATE_TABLE);
            logger.info("Database table created");
        } catch (SQLException e){
            logger.warning("Table failed to create: "+e);
        }


    }
    private static void dropOldTable (Connection connection){
        try (Statement statement = connection.createStatement();){
            statement.execute(Queryable.DROP_TABLE);
            logger.info("Old employee table dropped successfully");
        } catch (SQLException e){
            logger.warning("Table failed to drop: "+e);
        }
    }

    private static void importEmployeeEntries(Connection connection, HashSet<Employee> allEmployees) {

        try (PreparedStatement databaseEntries = connection.prepareStatement(Queryable.CREATE_NEW_EMPLOYEE);) {
            logger.info("Attempting to populate table");
            for (Employee employee : allEmployees) {
                databaseEntries.setString(1, employee.employeeID());
                databaseEntries.setString(2, employee.prefix());
                databaseEntries.setString(3, employee.firstName());
                databaseEntries.setString(4, employee.middleInitial());
                databaseEntries.setString(5, employee.lastName());
                databaseEntries.setString(6, employee.gender());
                databaseEntries.setString(7, employee.email());
                databaseEntries.setString(8, employee.dateOfBirth());
                databaseEntries.setString(9, employee.dateOfJoining());
                databaseEntries.setString(10, employee.salary());
                databaseEntries.execute();
            }

            logger.info("Database successfully populated with "+ allEmployees.size()+" entries");
        } catch (java.sql.SQLIntegrityConstraintViolationException e){
            logger.warning("Database already populated. To reinitialise please DROP old table");
        } catch (SQLException e) {
            logger.warning("Database failed to populate: "+e);
        }
    }


}
