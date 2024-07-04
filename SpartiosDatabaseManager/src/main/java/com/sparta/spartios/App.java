package com.sparta.spartios;


import com.sparta.spartios.Dao.EmployeeDAO;
import com.sparta.spartios.dbmanagement.ConnectToDatabase;
import com.sparta.spartios.dbmanagement.DatabaseInitialiser;
import com.sparta.spartios.logging.LoggerInitialiser;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public final static Logger logger = LoggerInitialiser.getLogger(Level.INFO, true);
    public static void main(String[] args) {

        EmployeeDAO accessEmployees = new EmployeeDAO();
//
//        System.out.println(accessEmployees.getEmployees());

        System.out.println(accessEmployees.getEmployee("179414").toString());
//
//        System.out.println(accessEmployees.getEmployees(LocalDate.of(2001,1,1),LocalDate.of(2003,1,1)));
//
//        System.out.println(accessEmployees.getEmployees(22, 30));
//
//        System.out.println(accessEmployees.getEmployees("sm"));

    }
}
