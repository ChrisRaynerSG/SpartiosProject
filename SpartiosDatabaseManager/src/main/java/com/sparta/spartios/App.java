package com.sparta.spartios;

import com.sparta.spartios.logging.LoggerInitialiser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public final static Logger logger = LoggerInitialiser.getLogger(Level.ALL, true);
    public static void main(String[] args) {
        // CSV reader - while removing corrupted entries
        // hashset the employees
        // Put clean file in DB
        // DAO to CRUD on DB
    }
}
