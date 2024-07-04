package com.sparta.spartios.dbmanagement;

public interface Queryable {

    //CREATE READ UPDATE DESTROY

    String SEARCH_BY_ID = "SELECT * FROM employees WHERE employeeID = '?'";
    String SEARCH_BY_NAME = "SELECT * FROM employees WHERE lastName LIKE '?'";
    String SEARCH_BY_AGE_RANGE = "SELECT * FROM employees WHERE age BETWEEN '?' AND '?'"; //How do we search for age from the database?
    String SEARCH_BY_JOIN_DATE = "SELECT * FROM employees WHERE dateOfJoining BETWEEN '?' AND '?'";
    String SEARCH_BY_GENDER = "SELECT * FROM employees WHERE gender = '?'";
    String SEARCH_BY_SALARY_RANGE = "SELECT * FROM employees WHERE salary BETWEEN '?' AND '?'";
    String UPDATE_RECORD = "UPDATE employees SET employeeID = ? , prefix = ? WHERE employeeID = '?' ";
    String DELETE_FROM_TABLE = "DELETE FROM employees WHERE employeeID = '?'";
    String CREATE_NEW_EMPLOYEE = "INSERT INTO employees VALUES('?','?','?','?','?','?','?','?','?','?')";


}
