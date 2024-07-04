package com.sparta.spartios.Dao;

import com.sparta.spartios.dtos.Employee;

import java.sql.*;
import java.util.HashSet;

import static com.sparta.spartios.App.logger;

public class DBQuerier {
    private Connection connection = null;
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private final String jdbcUserName = "root";
    private final String jdbcPassword = "root";

    public void establishConnection(){
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
            logger.info("Connected to database");
        } catch (SQLException e) {
            logger.warning("Failed to connect to database");
            e.printStackTrace();
        }
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

}
