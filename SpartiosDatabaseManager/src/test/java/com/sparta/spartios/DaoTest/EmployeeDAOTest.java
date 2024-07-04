package com.sparta.spartios.DaoTest;

import com.sparta.spartios.Dao.EmployeeDAO;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class EmployeeDAOTest {

    @Test
    void testtest(){
        EmployeeDAO dao = new EmployeeDAO();
        System.out.println(dao.getEmployee("847634"));

        System.out.println();
    }

    @Test
    void deleteEmployeeTest(){
        EmployeeDAO dao = new EmployeeDAO();
        dao.deleteEmployee("847634");

    }
}
