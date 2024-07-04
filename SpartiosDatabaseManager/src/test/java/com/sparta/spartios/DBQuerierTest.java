package com.sparta.spartios;

import com.sparta.spartios.Dao.DBQuerier;
import com.sparta.spartios.datasanitisation.DataCheck;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class DBQuerierTest {

    @Test
    void testtest(){
        DBQuerier db = new DBQuerier();
        HashSet<Employee> employeesFromDB = db.queryDB();
        System.out.println();
    }
}
