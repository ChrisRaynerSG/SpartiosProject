package com.sparta.spartios.Dao;


import com.sparta.spartios.Loggable;
import com.sparta.spartios.dtos.Employee;
import com.sparta.spartios.logging.LoggerInitialiser;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO implements DAO, Loggable {

    private static final DBQuerier db = new DBQuerier();

    @Override
    public HashSet<Employee> getEmployees() {
        db.queryDB();
        return null;
    }

    @Override
    public Employee getEmployee(String EmployeeID) {
        return null;
    }

    @Override
    public HashSet<Employee> getEmployees(String lastName) {
        return null;
    }

    @Override
    public HashSet<Employee> getEmployees(LocalDate hiredAfter, LocalDate hiredBefore) {
        return null;
    }

    @Override
    public HashSet<Employee> getEmployees(Integer olderThan, Integer youngerThan) {
        return null;
    }
}
