package com.sparta.spartios.Dao;


import com.sparta.spartios.dtos.Employee;

import java.time.LocalDate;
import java.util.HashSet;

public class EmployeeDAO implements DAO {

    private static final DBQuerier db = new DBQuerier();

    @Override
    public HashSet<Employee> getEmployees() {
        return db.queryDB(QueryBuilder.get("*", QueryBuilder.from("Employees")));
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
