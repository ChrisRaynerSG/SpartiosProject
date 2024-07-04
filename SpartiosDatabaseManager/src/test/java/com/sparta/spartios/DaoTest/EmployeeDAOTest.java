package com.sparta.spartios.DaoTest;

import com.sparta.spartios.Dao.DBQuerier;
import com.sparta.spartios.Dao.EmployeeDAO;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class EmployeeDAOTest {

    @Test
    void testtest(){
        EmployeeDAO dao = new EmployeeDAO();
        HashSet<Employee> employeesFromDB = dao.getEmployees(22,30);
        for(Employee employee : employeesFromDB){
            System.out.println(employee);
        }
        System.out.println();
    }
}
