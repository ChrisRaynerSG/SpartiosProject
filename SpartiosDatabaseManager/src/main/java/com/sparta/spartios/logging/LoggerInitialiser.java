package com.sparta.spartios.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerInitialiser{
    // Use this in the class you want:
    // final static Logger logger = LoggerInitialiser.getLogger(Level.ALL, Level.FINE, false, false);
    // Console Level, File Level, Append to file?, Use simple format?
    // Simple format means it does not record the time and place of the error. The file always uses complex format

    public static final Logger logger = Logger.getLogger(LoggerInitialiser.class.getName());

    public static Logger getLogger (Level consoleLevel,Level fileLevel, boolean append, boolean isSimple){
        setupConsoleHandler(consoleLevel, isSimple);
        setupFileHandler(fileLevel,append,Thread.currentThread().getStackTrace()[2].getClassName());
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        return logger;
    }
    public static void setupConsoleHandler(Level level, boolean isSimple) {

        ConsoleHandler consoleHandler = new ConsoleHandler();
        if (isSimple){
            consoleHandler.setFormatter(new CustomFormatterReadable());
        } else {
            consoleHandler.setFormatter(new CustomFormatterTerminal());
        }
        consoleHandler.setLevel(level);
        logger.addHandler(consoleHandler);

    }
    public static void setupFileHandler(Level level, boolean append, String filepath){
        try {

            String[] name = filepath.split("\\.");
            filepath = name[name.length -1];
            // TODO trim name
            FileHandler fileHandler = new FileHandler("src/main/resources/log-file-"+filepath+".log",append); //log files should be in the gitignore
            fileHandler.setLevel(level);
            fileHandler.setFormatter(new CustomFormatterFile());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to set up file handler");
            throw new RuntimeException(e);
        }
    }

}
