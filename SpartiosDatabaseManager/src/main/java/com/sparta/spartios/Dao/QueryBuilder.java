package com.sparta.spartios.Dao;

import com.sparta.spartios.dtos.Employee;

public class QueryBuilder {

    private static String get(String columnNames){
        return "SELECT " + columnNames + " ";
    }

    public static String get(String columnNames, String fromStatement){
        return get(columnNames) + fromStatement;
    }

    public static String from(String tableName, String whereStatement){
        return "FROM "+ tableName + " " + whereStatement;
    }

    public static String from(String tableName){
        return "FROM "+ tableName;
    }

    public static String isLike(String comparison){
        return " LIKE '%" + comparison +"%'";
    }

    public static String where(String columnName, String comparison){
        return "WHERE "+ columnName + comparison;
    }

    public static String isEqualTo(String equalTo){
        return " = '" + equalTo + "'";
    }

    public static String isGreaterThan(String greaterThan){
        return " > '" + greaterThan + "'";
    }

    public static String isLessThan(String lessThan){
        return " < '" + lessThan + "'";
    }

    public static String isBetween(String moreThan,String lessThan){
        return " BETWEEN '" + moreThan + "' AND '" + lessThan +"'";
    }

    public static String update(String tableName,String setStatement,String whereStatement){
        return "UPDATE "+ tableName + " " + setStatement + " " + whereStatement;
    }

  
    public static String changeTo(String columnName, String valueToChangeTo){
        return "SET "+columnName+" = '"+valueToChangeTo+"'";
    }

    public static String change(String columnName, String toStatement){
        return "SET " + columnName + " = " + toStatement;
    }

    public static String to(String valueToChangeTo){
        return "'" + valueToChangeTo + "'";
    }

    public static String deleteFrom(String tableName, String whereStatement){
        return "DELETE FROM " + tableName + " " + whereStatement;
    }

    public static String deleteFrom(String tableName){
        return "DELETE FROM " + tableName;
    }

    public static String insertInto(String tableName, Employee employee){
        return "INSERT INTO " + tableName + " VALUES ('"+employee.employeeID()+"','"+employee.prefix()+"','"+employee.firstName()
                +"','"+employee.middleInitial()+"','"+employee.lastName()+"','"+employee.gender()+"','"+employee.email()+"','"
                + employee.dateOfBirth()+"','"+employee.dateOfJoining()+"','"+employee.salary()+"');";
    }
}

