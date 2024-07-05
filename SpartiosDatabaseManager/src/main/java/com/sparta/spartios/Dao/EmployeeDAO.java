package com.sparta.spartios.Dao;


import com.sparta.spartios.dtos.Employee;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

import static com.sparta.spartios.App.logger;
import static com.sparta.spartios.Dao.QueryBuilder.*;
import static com.sparta.spartios.Dao.QueryOptions.*;

public class EmployeeDAO implements DAO {

    private static final DBQuerier db = new DBQuerier();

    @Override
    public HashSet<Employee> getEmployees() {
        logger.fine("In getEmployees");
        return db.queryDB(get(EVERYTHING, from(EMPLOYEES)));
    }

    @Override
    public Employee getEmployee(String EmployeeID) {
        logger.fine("In getEmployee");
        Iterator<Employee> employeeFound = db.queryDB(get(EVERYTHING,from(EMPLOYEES,where(EMPLOYEE_ID,isEqualTo(EmployeeID))))).iterator();
        if(employeeFound.hasNext()){
            return employeeFound.next();
        }else {
            return null;
        }

    }

    @Override
    public HashSet<Employee> getEmployees(String lastName) {
        logger.fine("In getEmployees");
        return db.queryDB(get(EVERYTHING,from(EMPLOYEES,where(LAST_NAME,isLike(lastName)))));
    }

    @Override
    public HashSet<Employee> getEmployees(LocalDate joinedAfter, LocalDate joinedBefore) {
        logger.fine("In getEmployees");
        return db.queryDB(get(EVERYTHING,from(EMPLOYEES,where(DATE_OF_JOINING,isBetween(joinedAfter.toString(),joinedBefore.toString())))));
    }

    @Override
    public HashSet<Employee> getEmployees(Integer olderThan, Integer youngerThan) {
        logger.fine("In getEmployees");
        LocalDate bornBefore = LocalDate.now().minusYears(olderThan);
        LocalDate bornAfter = LocalDate.now().minusYears(youngerThan);
        return db.queryDB(get(EVERYTHING,from(EMPLOYEES,where(DATE_OF_BIRTH,isBetween(bornAfter.toString(),bornBefore.toString())))));
    }

    @Override
    public void deleteEmployee(String EmployeeID) {
        logger.fine("In deleteEmployee");
        db.deleteFromDB(deleteFrom(EMPLOYEES,where(EMPLOYEE_ID,isEqualTo(EmployeeID))));
    }

    @Override
    public void addEmployee(Employee EmployeeID) {
    }

}
