package com.sparta.spartios.DaoTest;

import com.sparta.spartios.Dao.DBQuerier;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class DBQuerierTest {

    @Test
    void testtest(){
        DBQuerier db = new DBQuerier();
        HashSet<Employee> employeesFromDB = db.queryDB("SELECT * FROM employees");
        System.out.println();
    }
}
