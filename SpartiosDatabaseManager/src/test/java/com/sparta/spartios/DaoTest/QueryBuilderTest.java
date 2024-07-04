package com.sparta.spartios.DaoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.sparta.spartios.Dao.QueryBuilder.*;
import static com.sparta.spartios.Dao.QueryOptions.*;

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

    @Test
    void testUpdateRecordGenderChange(){
        String query = update(EMPLOYEES,changeTo(GENDER,"M"),where(EMPLOYEE_ID,isEqualTo("115556")));
        Assertions.assertEquals("UPDATE employees SET gender = 'M' WHERE emp_id = '115556'",query);
    }

    @Test
    void testUpdateRecordDateChange(){
        String query = update(EMPLOYEES,changeTo(DATE_OF_BIRTH,"2000/03/07"),where(EMPLOYEE_ID,isEqualTo("115556")));
        Assertions.assertEquals("UPDATE employees SET DOB = '2000-03-07' WHERE emp_id = '115556'",query);
    }
}
