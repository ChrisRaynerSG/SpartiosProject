package com.sparta.spartios;


import com.sparta.spartios.Dao.EmployeeDAO;
import com.sparta.spartios.dbmanagement.ConnectToDatabase;
import com.sparta.spartios.dbmanagement.DatabaseInitialiser;
import com.sparta.spartios.logging.LoggerInitialiser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public final static Logger logger = LoggerInitialiser.getLogger(Level.INFO, true);
    public static void main(String[] args) {

        DatabaseInitialiser.instantiateDatabase(ConnectToDatabase.employeeDatabaseConnection(), true);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.getEmployees();
    }
}
