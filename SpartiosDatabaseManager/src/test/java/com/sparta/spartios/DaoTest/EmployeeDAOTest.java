package com.sparta.spartios.DaoTest;

import com.sparta.spartios.Dao.EmployeeDAO;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class EmployeeDAOTest {

    //Had a difficult time actually writing tests so I mostly manually tested in here
    @Test
    void sampleTest(){
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
