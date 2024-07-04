package com.sparta.spartios.Dao;

import com.sparta.spartios.dtos.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.stream.Collectors;

import static com.sparta.spartios.App.logger;

public class DBParser {

    public static HashSet<Employee> getResultAsEmployees(ResultSet result){
        HashSet<String> resultAsStrings = getResultAsStrings(result);
        logger.fine("Converting string results to Employee records");
        HashSet<Employee> resultAsEmployees = resultAsStrings.stream()
                .map(string -> string.split(","))
                .map(strings -> new Employee(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7],strings[8],strings[9]))
                .collect(Collectors.toCollection(HashSet::new));

        return resultAsEmployees;
    }
    public static HashSet<String> getResultAsStrings(ResultSet result){
        logger.fine("Getting results from db as strings");
        HashSet<String> resultAsStrings = new HashSet<>();
        int columnCount = 10;

        try {
            while(result.next()) {
                logger.finer("Iterating through db results and converting them to strings");
                StringBuilder builder = new StringBuilder();
                for(int i = 1; i <= columnCount; i++){
                    builder.append(result.getString(i)).append(",");
                }
                resultAsStrings.add(builder.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultAsStrings;
    }



}
