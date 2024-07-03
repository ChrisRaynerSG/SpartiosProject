package com.sparta.spartios;

import com.sparta.spartios.datasanitisation.DataCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DataCheckTests {

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
}
