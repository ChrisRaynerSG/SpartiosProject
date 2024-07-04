package com.sparta.spartios;

import com.sparta.spartios.datasanitisation.DataCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;


public class DatabaseInitialiserTest {


    public static void main(String[] args) {
        Connection connection = ConnectToDatabase.employeeDatabaseConnection();

        DatabaseInitialiser.instantiateDatabase(connection);
    }


}
