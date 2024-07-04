package com.sparta.spartios.Dao;

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

    public static String where(String columnName, String equals){
        return "WHERE "+ columnName + " = '" + equals + "'";
    }

}
