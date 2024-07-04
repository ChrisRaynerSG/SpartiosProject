package com.sparta.spartios;

import com.sparta.spartios.Dao.DBQuerier;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.sparta.spartios.Dao.QueryBuilder.*;
import static com.sparta.spartios.Dao.QueryOptions.*;

import java.util.HashSet;

public class QueryBuilderTest {

    @Test
    void returnExpectedSelectStatement(){
        String query = get(EVERYTHING,from(EMPLOYEES));
        Assertions.assertEquals("SELECT * FROM employees",query);
    }
    @Test
    void returnExpectedSelectStatementWithWhereIsEqualTo(){
        String query = get(EVERYTHING,from(EMPLOYEES,where(EMPLOYEE_ID,isEqualTo("178566"))));
        Assertions.assertEquals("SELECT * FROM employees WHERE emp_id = '178566'",query);
    }

    @Test
    void returnExpectedSelectStatementWithWhereIsLessThan(){
        String query = get(EVERYTHING,from(EMPLOYEES,where(SALARY,isLessThan("100000"))));
        Assertions.assertEquals("SELECT * FROM employees WHERE salary < '100000'",query);
    }

    @Test
    void returnExpectedSelectStatementWithWhereIsGreaterThan(){
        String query = get(EVERYTHING,from(EMPLOYEES,where(SALARY,isGreaterThan("100000"))));
        Assertions.assertEquals("SELECT * FROM employees WHERE salary > '100000'",query);
    }

    @Test
    void returnExpectedSelectStatementWithWhereLike(){
        String query = get(EVERYTHING,from(EMPLOYEES,where(LAST_NAME,isLike("oj"))));
        Assertions.assertEquals("SELECT * FROM employees WHERE last_name LIKE '%oj%'",query);
    }

    @Test
    void returnExpectedSelectStatementWithBetween(){
        String query = get(EVERYTHING,from(EMPLOYEES,where(SALARY,isBetween("50000","100000"))));
        Assertions.assertEquals("SELECT * FROM employees WHERE salary BETWEEN '50000' AND '100000'",query);
    }

}
