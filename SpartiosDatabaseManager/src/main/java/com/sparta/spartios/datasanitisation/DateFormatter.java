package com.sparta.spartios.datasanitisation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
    public static String getFormattedDate(String inputDate){
        StringBuilder formattedDate = new StringBuilder();
        String[] splitDate = inputDate.split("/");
        return formattedDate.append(splitDate[2]).append("/").append(splitDate[0]).append("/").append(splitDate[1]).toString();

    }
}
