package com.sparta.spartios.Dao;

import com.sparta.spartios.Loggable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBParser implements Loggable {

    public static List<String> getResultsAsStrings(ResultSet result){
        logger.fine("Getting results from db as strings");
        ArrayList<String> resultAsStrings = new ArrayList<>();
        int columnCount = 10;

        try {
            while(result.next()) {
                logger.finer("Iterating through db results and converting them to strings");
                StringBuilder builder = new StringBuilder();
                for(int i = 1; i <= columnCount; i++){
                    builder.append(result.getString(i));
                }
                resultAsStrings.add(builder.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultAsStrings;
    }
}
