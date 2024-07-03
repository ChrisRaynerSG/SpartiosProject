package com.sparta.spartios.filereader;

import com.sparta.spartios.logging.LoggerInitialiser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.*;

public class CsvReader{
    final static Logger logger = LoggerInitialiser.getLogger(Level.ALL, Level.FINE, false, false);

    public static HashSet<String> getAllLines(){
        //Maybe change hashset to ArrayList depending on how to access data for cleaning
        HashSet<String> lines = new HashSet<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/employees-corrupted(in).csv"))){
            logger.log(Level.FINE, "Init file read");
            String line;
            while((line = bufferedReader.readLine())!= null){
                logger.log(Level.FINER, "Added line: " +line + "\nTo Hash Set");
                lines.add(line);

            }
            return lines;
        }
        catch (IOException e){
            logger.log(Level.WARNING, "File to read not found");
        }
        finally {
            return lines;
        }
    }
}