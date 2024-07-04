package com.sparta.spartios;

import com.sparta.spartios.logging.LoggerInitialiser;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Loggable {
    Logger logger = LoggerInitialiser.getLogger(Level.ALL, Level.FINE, false, false);
}
