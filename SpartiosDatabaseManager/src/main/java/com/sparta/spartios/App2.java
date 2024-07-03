package com.sparta.spartios;

import com.sparta.spartios.logging.LoggerInitialiser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App2 {
    final static Logger logger = LoggerInitialiser.getLogger(Level.ALL, false);
    public static void loggercheck(){
        logger.info("Second test message");
    }
}
