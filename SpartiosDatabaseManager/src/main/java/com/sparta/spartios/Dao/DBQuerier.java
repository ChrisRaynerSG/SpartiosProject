package com.sparta.spartios.Dao;

import com.sparta.spartios.dbmanagement.ConnectToDatabase;
import com.sparta.spartios.dtos.Employee;

import java.sql.*;
import java.util.HashSet;

import static com.sparta.spartios.App.logger;

public class DBQuerier {
    private Connection connection = null;

    public void establishConnection(){
        connection = ConnectToDatabase.employeeDatabaseConnection();
    }

    public void closeConncetion(){
        try {
            connection.close();
            logger.info("Closed connection to database");
        } catch (SQLException e) {
            logger.warning("Failed to close connection to database");
            e.printStackTrace();
        }
    }

    public HashSet<Employee> queryDB(String query){
        establishConnection();
        ResultSet resultOfQuery = null;
        try {
            logger.info("Attempting to query database");
            Statement getStatement = connection.createStatement();
            resultOfQuery = getStatement.executeQuery(query);
        } catch (SQLException e) {
            logger.warning("Failed to query the database");
            e.printStackTrace();
        }
        HashSet<Employee> results = DBParser.getResultAsEmployees(resultOfQuery);
        closeConncetion();

        return results;
    }

    public void deleteFromDB(String deleteStatement){
        establishConnection();
        try {
            logger.info("Attempting to delete from database");
            Statement getStatement = connection.createStatement();
            getStatement.executeUpdate(deleteStatement);
        } catch (SQLException e) {

            logger.warning("Failed to delete from the database");
            e.printStackTrace();

        }
        closeConncetion();
    }
    public void updateDb(String updateStatement){
        establishConnection();
        try {
            Statement getStatement = connection.createStatement();
            getStatement.executeUpdate(updateStatement);
            logger.info("Update successful");
        } catch (SQLException e) {
            logger.warning("Error with update: "+ e);
        }
    }
}
