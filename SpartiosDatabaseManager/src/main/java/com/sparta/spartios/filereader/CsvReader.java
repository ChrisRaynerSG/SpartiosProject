package com.sparta.spartios.filereader;

import com.sparta.spartios.datasanitisation.DataCheck;
import com.sparta.spartios.datasanitisation.DuplicateEmployeeIDPredicate;
import com.sparta.spartios.dtos.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.sparta.spartios.App.logger;

public class CsvReader{
    public static HashSet<Employee> getAllLines(){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/employees-corrupted(in).csv"))){

             return bufferedReader.lines()
                    .skip(1)
                    .map(string -> string.split(","))
                    .filter(strings -> DataCheck.isValidId(strings[0]))
                     .filter(strings -> DataCheck.isValidFirstName(strings[2]))
                     .filter(strings -> DataCheck.isValidMiddleInitial(strings[3]))
                     .filter(strings -> DataCheck.isValidLastName(strings[4]))
                     .filter(strings -> DataCheck.isValidGender(strings[5]))
                     .filter(strings -> DataCheck.isValidEmail(strings[6]))
                     .filter(strings -> DataCheck.isValidDateOfBirth(strings[7]))
                     .filter(strings -> DataCheck.isValidDateOfJoining(strings[8],strings[7]))
                     .filter(strings -> DataCheck.isValidSalary(strings[9]))
                    .map(strings -> new Employee(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7],strings[8],strings[9]))
                     .filter(new DuplicateEmployeeIDPredicate())
                    .collect(Collectors.toCollection(HashSet::new));
        }
        catch (IOException e){
            logger.log(Level.WARNING, "File to read not found");
            return null;
        }
    }
}
