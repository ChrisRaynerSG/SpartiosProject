package com.sparta.spartios.Dao;

import com.sparta.spartios.Loggable;
import com.sparta.spartios.logging.LoggerInitialiser;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBQuerier implements Loggable {
    private Connection connection = null;
    private final String jdbcURL = "";
    private final String jdbcUserName = "";
    private final String jdbcPassword = "";

    private static final String[] EMPLOYEE_TABLE_HEADINGS = {"emp_id", "name_prefix", "first_name", "middle_initial", "last_name", "gender", "email", "date_of_birth", "date_of_joining", "salary"};

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

    public void queryDB(){
        establishConnection();
        ResultSet resultOfQuery = null;
        try {
            Statement getStatement = connection.createStatement();
            String query = "SELECT * FROM employee_db.employees";
            resultOfQuery = getStatement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConncetion();
        for(String s : DBParser.getResultsAsStrings(resultOfQuery)){
            System.out.println(s);
        }
        closeConncetion();

        //return resultOfQuery;
    }

}
