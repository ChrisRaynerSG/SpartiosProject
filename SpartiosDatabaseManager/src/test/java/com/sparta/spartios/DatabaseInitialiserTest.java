package com.sparta.spartios;

import com.sparta.spartios.dbmanagement.ConnectToDatabase;
import com.sparta.spartios.dbmanagement.DatabaseInitialiser;

import java.sql.Connection;


public class DatabaseInitialiserTest {


    public static void main(String[] args) {
        Connection connection = ConnectToDatabase.employeeDatabaseConnection();

        DatabaseInitialiser.instantiateDatabase(connection,true);
    }


}
