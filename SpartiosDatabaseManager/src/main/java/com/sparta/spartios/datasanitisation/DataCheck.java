package com.sparta.spartios.datasanitisation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.logging.Level;

import static com.sparta.spartios.App.logger;

public class DataCheck {
    private static int numberOfCorruptions;
    public static boolean isValidId(String id){

        logger.log(Level.FINE, "Entered has Valid ID method");

        if(id == null || id.length() != 6){
            logger.log(Level.FINER, "ID Invalid due to incorrect length returned with false");
            numberOfCorruptions++;
            return false;
        }

        else if(id.matches("[0-9]+")){
            logger.log(Level.FINER, "ID is valid returned with true");
            return true;
        }

        else{
            logger.log(Level.FINER, "ID is invalid as non digits present returned with false");
            numberOfCorruptions++;
            return false;
        }
    }

    public static boolean isValidPrefix(String prefix){

        //todo investigate valid prefixes as currently returning 500ish corruptions

        logger.log(Level.FINE, "Entered isValidPrefix method");
        if(prefix == null || prefix.isEmpty() || prefix.length() > 4){
            logger.log(Level.FINER, "Exited isValidPrefix method with false as prefix incorrect length");
            numberOfCorruptions++;
            return false;
        }
        if(prefix.matches("[a-zA-z]+.")){
            logger.log(Level.FINER, "Exited isValidPrefix method with true");
            return true;
        }
        else{
            logger.log(Level.FINER, "Exited isValidPrefix method with false as wrong characters present");
            numberOfCorruptions++;
            return false;
        }
        //as per requirements elicitation always returns true
        //todo write anyway for CRUD requests
    }

    public static boolean isValidFirstName(String firstName){

        //as per requirements elicitation always returns true
        //todo write anyway for CRUD requests

        logger.log(Level.FINE, "Entered isValidFirstName method");
        if(firstName == null || firstName.isEmpty()){
            logger.log(Level.FINER, "first name is invalid as String is empty returned false");
            numberOfCorruptions++;
            return false;
        }
        else if(firstName.matches("[a-zA-z]+")){
            logger.log(Level.FINER, "first name is valid returned true");
            return true;
        }
        else{
            logger.log(Level.FINER, "first name is invalid as contains non alphabet characters returned false");
            numberOfCorruptions++;
            return false;
        }
    }

    public static boolean isValidMiddleInitial(String middleInitial){
        logger.log(Level.FINE, "Entered isValidMiddleInitial method");

        if(middleInitial.length() == 1){
            return true;
        }
        numberOfCorruptions++;
        return false;
    }

    public static boolean isValidLastName(String lastName){

        logger.log(Level.FINE, "Entered isValidLastName method");
        if(lastName == null || lastName.isEmpty()){
            logger.log(Level.FINER, "last name is invalid as String is empty returned false");
            numberOfCorruptions++;
            return false;
        }
        else if(lastName.matches("[a-zA-z-]+")){
            logger.log(Level.FINER, "last name is valid returned true");
            return true;
        }
        else{
            logger.log(Level.FINER, "last name is invalid as contains non alphabet characters returned false");
            numberOfCorruptions++;
            return false;
        }
    }

    public static boolean isValidGender(String gender){
        logger.log(Level.FINE, "Entered isValidGender method");
        return gender.equals("M") || gender.equals("F");

        //todo rewrite this to log if returns true or false?
    }

    public static boolean isValidEmail(String email){
        logger.log(Level.FINE, "Entered is valid email method");

        if (email.matches("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$")){
            logger.log(Level.FINER, "Exited is valid email method with true return");
            return true;
        }
        else{
            logger.log(Level.FINER, "Exited is valid email method with false return");
            numberOfCorruptions++;
            return false;
        }
    }

    public static boolean isValidDateOfBirth(String dateOfBirth){

        //todo write functionality for dates of birth before and after specific dates

        logger.log(Level.FINE, "Entered isValidDateOfJoining method");
        if(dateOfBirth.length() <8 || dateOfBirth.length()>10){
            logger.log(Level.FINER, "Exited isValidDateOfBirth as incorrect length returned false");
            numberOfCorruptions++;
            return false;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.MONTH_OF_YEAR,1,2,SignStyle.NEVER)
                .appendLiteral('/')
                .appendValue(ChronoField.DAY_OF_MONTH,1,2,SignStyle.NEVER)
                .appendLiteral('/')
                .appendValue(ChronoField.YEAR,4)
                .toFormatter();
        try{
            LocalDate dateBirthDate = LocalDate.parse(dateOfBirth, formatter);
            logger.log(Level.FINER, "Date Of Birth is valid format");
            if(dateBirthDate.isAfter(LocalDate.now())){
                logger.log(Level.FINER, "Date Of Birth is after now, exited isDateOfBirthValid returned false");
                numberOfCorruptions++;
                return false;
            }
            logger.log(Level.FINER, "Date of Birth is valid");
            return true;
        }
        catch (DateTimeParseException e){
            logger.log(Level.FINER, "Date is invalid format returned false");
            numberOfCorruptions++;
            return false;
        }
    }

    public static boolean isValidDateOfJoining(String dateOfJoining, String dateOfBirth){
        logger.log(Level.FINE, "Entered isValidDateOfJoining method");
        if(dateOfJoining.length() <8|| dateOfJoining.length()>10 || dateOfBirth.length() <8 || dateOfBirth.length() > 10){
            logger.log(Level.FINER, "Dates are invalid as incorrect length returned false");
            numberOfCorruptions++;
            return false;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.MONTH_OF_YEAR,1,2, SignStyle.NEVER)
                .appendLiteral('/')
                .appendValue(ChronoField.DAY_OF_MONTH,1,2,SignStyle.NEVER)
                .appendLiteral('/')
                .appendValue(ChronoField.YEAR,4)
                .toFormatter();
        try{
            LocalDate dateJoinDate = LocalDate.parse(dateOfJoining, formatter);
            LocalDate dateBirthDate = LocalDate.parse(dateOfBirth, formatter);
            logger.log(Level.FINER, "Dates are valid format");
            if(dateJoinDate.isBefore(dateBirthDate)){
                logger.log(Level.FINER, "Date of joining is before Date of Birth");
                numberOfCorruptions++;
                return false;
            }
            logger.log(Level.FINER, "Date of Joining is valid");
            return true;
        }
        catch (DateTimeParseException e){
            logger.log(Level.FINER, "Dates are invalid format returned false");
            numberOfCorruptions++;
            return false;
        }
    }

    public static boolean isValidSalary(String salary){

        //todo check if salary is valid and get clarification if salary of 0 is corrupted data

        logger.log(Level.FINER, "Entered check is valid salary method");
        if(Integer.parseInt(salary)<=0){
            logger.log(Level.FINER, "Exited check is valid salary method with false return");
            numberOfCorruptions++;
            return false;
        }
        logger.log(Level.FINER, "Exited check is valid salary method with true return");
        return true;
    }

    public static int getNumberOfCorruptions(){
        return numberOfCorruptions;
    }
}
