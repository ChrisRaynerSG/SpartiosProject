package com.sparta.spartios.Dao;

import java.sql.*;

import static com.sparta.spartios.App.logger;

public class DBQuerier {
    private Connection connection = null;
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private final String jdbcUserName = "root";
    private final String jdbcPassword = "root";

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
            logger.warning("" + resultOfQuery.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(String s : DBParser.getResultsAsStrings(resultOfQuery)){
            System.out.println(s);
        }
        closeConncetion();

        //return resultOfQuery;
    }

}
