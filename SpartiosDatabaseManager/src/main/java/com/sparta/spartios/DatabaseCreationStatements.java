package com.sparta.spartios;

public interface DatabaseCreationStatements {

    String createDatabase = "CREATE DATABASE employee_data";
    String createTable = "DROP TABLE IF EXISTS employees; "+
                        "CREATE TABLE employees("+
                        "Emp_ID INT(6) PRIMARY KEY,"+
	                    "Name_Prefix VARCHAR(7),"+
                        "First_Name VARCHAR(30),"+
                        "Middle_Initial CHAR(1),"+
                        "Last_Name VARCHAR(30),"+
                        "Gender CHAR(1),"+
                        "E_Mail VARCHAR(100),"+
                        "DOB VARCHAR(10),"+
                        "DOJ VARCHAR(10),"+
                        "Salary INT"+
                        ")";
    String importData = "INSERT INTO employees (emp_id, name_prefix, first_name, middle_initial, last_name, gender, e_mail, DOB, DOJ, salary) VALUES"+
                        "(?,?,?,?,?,?,?,?,?,?)";

}