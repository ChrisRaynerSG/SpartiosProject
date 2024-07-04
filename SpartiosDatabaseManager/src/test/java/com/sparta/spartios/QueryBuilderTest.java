package com.sparta.spartios;

import com.sparta.spartios.Dao.DBQuerier;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.sparta.spartios.Dao.QueryBuilder.*;

import java.util.HashSet;

public class QueryBuilderTest {

    @Test
    void returnExpectedSelectStatement(){
        String query = get("*",from("employees"));
        Assertions.assertEquals("SELECT * FROM employees",query);
    }
    @Test
    void returnExpectedSelectStatementWithWhere(){
        String query = get("*",from("employees",where("emp_id","178566")));
        Assertions.assertEquals("SELECT * FROM employees WHERE emp_id = '178566'",query);
    }

}
