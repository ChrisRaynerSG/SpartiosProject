package com.sparta.spartios.Dao;

import com.sparta.spartios.dtos.Employee;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public interface DAO {
    HashSet<Employee> getEmployees();
    Employee getEmployee(String EmployeeID);
    HashSet<Employee> getEmployees(String lastName);
    HashSet<Employee> getEmployees(LocalDate hiredAfter, LocalDate hiredBefore);
    HashSet<Employee> getEmployees(Integer olderThan, Integer youngerThan);
}