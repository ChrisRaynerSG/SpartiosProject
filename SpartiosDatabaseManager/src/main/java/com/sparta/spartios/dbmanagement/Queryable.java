package com.sparta.spartios.dbmanagement;

public interface Queryable {

    //CREATE READ UPDATE DESTROY

    String SEARCH_BY_ID = "SELECT * FROM employees WHERE employeeID = '?'";
    String SEARCH_BY_NAME = "SELECT * FROM employees WHERE lastName LIKE '?'";
    String SEARCH_BY_AGE_RANGE = "SELECT * FROM employees WHERE DATEDIFF(YEAR, dateOfBirth, GETDATE()) BETWEEN '?' AND '?'"; // 46 60 How do we search for age from the database?
    String SEARCH_BY_JOIN_DATE = "SELECT * FROM employees WHERE dateOfJoining BETWEEN '?' AND '?'";
    String SEARCH_BY_GENDER = "SELECT * FROM employees WHERE gender = '?'";
    String SEARCH_BY_SALARY_RANGE = "SELECT * FROM employees WHERE salary BETWEEN '?' AND '?'";
    String UPDATE_RECORD = "UPDATE employees SET employeeID = ? , prefix = ? WHERE employeeID = '?' ";
    String DELETE_FROM_TABLE = "DELETE FROM employees WHERE employeeID = '?'";
    String CREATE_NEW_EMPLOYEE = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?)";


    String CREATE_DATABASE = "CREATE DATABASE employee_data";
    String CREATE_TABLE = "CREATE TABLE employees("+
            "Emp_ID INT(6) PRIMARY KEY,"+
            "Name_Prefix VARCHAR(7),"+
            "First_Name VARCHAR(30),"+
            "Middle_Initial CHAR(1),"+
            "Last_Name VARCHAR(30),"+
            "Gender CHAR(1),"+
            "E_Mail VARCHAR(100),"+
            "DOB DATE,"+
            "DOJ DATE,"+
            "Salary INT"+
            ")";
    String DROP_TABLE = "DROP TABLE IF EXISTS employees";
}
