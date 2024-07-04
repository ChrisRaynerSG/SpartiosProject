package com.sparta.spartios;

public interface DatabaseCreationStatements {

    String createDatabase = "CREATE DATABASE employee_data";
    String createTable = "CREATE TABLE employees("+
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
    String importData = "INSERT INTO employees (emp_id, name_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_joining, salary) VALUES"+
                        "(?,?,?,?,?,?,?,?,?,?)";

}
