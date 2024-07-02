package com.sparta.spartios;

import com.sparta.spartios.logging.LoggerInitialiser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    final static Logger logger = LoggerInitialiser.getLogger(Level.ALL, Level.FINE, false, true);
    public static void main(String[] args) {
        logger.info("test string");
    }
}
