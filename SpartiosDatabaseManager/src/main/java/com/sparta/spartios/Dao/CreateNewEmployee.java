package com.sparta.spartios.Dao;

import com.sparta.spartios.datasanitisation.DataCheck;
import com.sparta.spartios.datasanitisation.DateFormatter;
import com.sparta.spartios.datasanitisation.DuplicateEmployeeIDPredicate;
import com.sparta.spartios.dtos.Employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static com.sparta.spartios.Dao.QueryBuilder.*;
import static com.sparta.spartios.Dao.QueryOptions.*;
import static com.sparta.spartios.App.logger;

public class CreateNewEmployee {

    //REMOVE IF ADDING TO DAO
    public EmployeeDAO accessEmployees = new EmployeeDAO();

    private static final DBQuerier db = new DBQuerier();

    public void createEmployee(Employee employee){
        HashSet<Employee> currentEmployees = accessEmployees.getEmployees();
        if(DataCheck.isValidEmployee(employee)){
            currentEmployees.add(employee);
            currentEmployees = currentEmployees.stream().filter(new DuplicateEmployeeIDPredicate()).collect(Collectors.toCollection(HashSet::new));
            if(currentEmployees.contains(employee)){
                logger.log(Level.INFO, "New Employee added to the database!");
                db.queryDB(insertInto(EMPLOYEES,employee));
            }
            else {
                logger.log(Level.FINE, "Employee with duplicate ID! Aborting database addition.");
            }
        }
        else{
            logger.log(Level.FINE, "Employee input invalid. Aborting database addition.");
        }
    }
}
