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
        logger.info("Connected to database");
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
            Statement getStatement = connection.createStatement();
            resultOfQuery = getStatement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HashSet<Employee> results = DBParser.getResultAsEmployees(resultOfQuery);
        closeConncetion();

        return results;
    }

    public void deleteFromDB(String deleteStatement){
        establishConnection();
        try {
            Statement getStatement = connection.createStatement();
            getStatement.executeUpdate(deleteStatement);
        } catch (SQLException e) {
            logger.warning("Error with deletion: "+ e);
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
