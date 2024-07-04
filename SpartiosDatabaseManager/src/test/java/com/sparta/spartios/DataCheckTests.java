package com.sparta.spartios;

import com.sparta.spartios.datasanitisation.DataCheck;
import com.sparta.spartios.datasanitisation.DuplicateEmployeeIDPredicate;
import com.sparta.spartios.dtos.Employee;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class DataCheckTests {

    static ArrayList<Employee> employees = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        Employee employee = new Employee("123456", null, null, null, null, null, null, null, null, "123456");
        Employee employee2 = new Employee("123456", null, null, null, null, null, null, null, null, "654321");
        Employee employee3 = new Employee("123455", null, null, null, null, null, null, null, null, "654321");
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);

    }

    @Test
    @DisplayName("Given prefix of Dr. return true")
    void givenPrefixofDrPeriodReturnTrue(){
        String prefix = "Dr.";
        boolean expected = true;
        boolean actual = DataCheck.isValidPrefix(prefix);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Given Date of Birth after current date return false")
    void givenDateOfBirthAfterCurrentDateReturnFalse(){
        String date1 = "10/10/2027";
        boolean expected = false;
        boolean actual = DataCheck.isValidDateOfBirth(date1);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenNullStringReturnFalseForIDCheck(){
        String input = null;
        boolean expected = false;
        boolean actual = DataCheck.isValidId(input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenStringLengthLessThanSixReturnFalseForIDCheck(){
        String input = "12345";
        boolean expected = false;
        boolean actual = DataCheck.isValidId(input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenStringLengthOfSixThenReturnTrueForIDCheck(){
        String input = "123456";
        boolean expected = true;
        boolean actual = DataCheck.isValidId(input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenStringLengthOfSixAndIncludesLettersThenReturnFalseForIDCheck(){
        String input = "123r56";
        boolean expected = false;
        boolean actual = DataCheck.isValidId(input);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void givenStringIfNumbersPresentReturnFalseForIsValidLastName() {
        String input = "43asg432";
        boolean expected = false;
        boolean actual = DataCheck.isValidLastName(input);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringIfNoNumbersPresentReturnTrueForIsValidLastName() {
        String input = "jerry";
        boolean expected = true;
        boolean actual = DataCheck.isValidLastName(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenTwoEmployeesWithIdenticalIDReturnFalse(){
        boolean expected =false;
        DuplicateEmployeeIDPredicate predicate = new DuplicateEmployeeIDPredicate();
        predicate.test(employees.get(0));
        boolean actual = predicate.test(employees.get(1));
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenTwoEmployeesWithDifferentIDReturnTrue(){
        boolean expected =true;
        DuplicateEmployeeIDPredicate predicate = new DuplicateEmployeeIDPredicate();
        predicate.test(employees.get(0));
        boolean actual = predicate.test(employees.get(2));
        Assertions.assertEquals(expected,actual);
    }
}
