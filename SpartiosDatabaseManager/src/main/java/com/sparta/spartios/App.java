package com.sparta.spartios;

import com.sparta.spartios.Dao.EmployeeDAO;

import com.sparta.spartios.datasanitisation.InputValidation;

import com.sparta.spartios.dtos.Employee;
import com.sparta.spartios.logging.LoggerInitialiser;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public final static Logger logger = LoggerInitialiser.getLogger(Level.INFO, true);
    public static void main(String[] args) {

        EmployeeDAO accessEmployees = new EmployeeDAO();

        HashSet<Employee> consoleOutput = new HashSet<>();

        //CHANGE BELOW INPUTS FOR SEARCH

        String searchByID = "179414";
        String searchByName = "Smith";
        String searchByAgeLower = "22";
        String searchByAgeUpper = "45";
        String joinDateLower = "01/01/1992"; //MM/dd/yyyy
        String joinDateUpper = "01/01/2007"; //MM/dd/yyyy
        Employee employeeToAdd = new Employee("554433","Dr.","Mantis","D","Toboggan","M","magnum.toboggan@reynolds.com","5/5/1980","1/1/2008","1234506656");

        final String invalidInput = "Invalid Input!";

        //SEARCH ALL

//        consoleOutput = accessEmployees.getEmployees();
//        printResultsToConsole(consoleOutput);

        //SEARCH BY ID

//        if(InputValidation.hasValidID(searchByID)){
//            System.out.println(accessEmployees.getEmployee(searchByID).toString());
//        }

        //SEARCH BY NAME

        if(InputValidation.hasValidPartialName(searchByName)){
            consoleOutput = accessEmployees.getEmployees(searchByName);
            printResultsToConsole(consoleOutput);
        }

        else{
            System.out.println(invalidInput);
        }

        //SEARCH BY AGE RANGE

        if(InputValidation.hasValidAgeRange(searchByAgeLower,searchByAgeUpper)){
            consoleOutput = accessEmployees
                    .getEmployees(Integer.parseInt(searchByAgeLower),
                        Integer.parseInt(searchByAgeUpper));
            printResultsToConsole(consoleOutput);

        }

        else{
            System.out.println(invalidInput);
        }

        //SEARCH BY DATE OF JOINING

        if(InputValidation.hasValidDates(joinDateLower, joinDateUpper)){
            LocalDate date1 = LocalDate.parse(joinDateLower, InputValidation.formatInputDates());
            LocalDate date2 = LocalDate.parse(joinDateUpper, InputValidation.formatInputDates());

            consoleOutput = accessEmployees.getEmployees(date1,date2);
            printResultsToConsole(consoleOutput);
        }
        else{
            System.out.println(invalidInput);
        }

//        System.out.println(DataCheck.getNumberOfCorruptions());

        //DELETE EMPLOYEE FROM RECORD
//        if(InputValidation.hasValidID(searchByID)){
//            accessEmployees.deleteEmployee(searchByID);
//        }

        //ADD NEW EMPLOYEE

        if(InputValidation.hasValidID(searchByID)){
            accessEmployees.createEmployee(employeeToAdd);
            System.out.println(accessEmployees.getEmployee("554433").toString());
        }

    }

    private static void printResultsToConsole(HashSet<Employee> consoleOutput) {
        for(Employee employee : consoleOutput){
            System.out.println(employee.toString()+"\n");
        }
    }
}
