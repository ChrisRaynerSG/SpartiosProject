package com.sparta.spartios.logging;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatterTerminal extends Formatter {
    private static final String[] colour = {"\u001B[38;2;255;30;38m ","\u001B[38;2;255;148;30m ","\u001B[38;2;255;255;0m "
                                            ,"\u001B[38;2;6;189;0m ","\u001B[38;2;0;26;152m ","\u001B[38;2;118;0;136m "
                                            ,"\u001B[38;2;0;0;0m ", "\u001B[38;2;96;56;20m "
                                            ,"\u001B[38;2;117;213;235m ","\u001B[38;2;253;175;199m ","\u001B[38;2;255;255;255m "};
    private static int index = colour.length-2;
    @Override
    public String format(LogRecord record) {
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd MMM");
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        index += 2;
        if (index > colour.length + 2){
            index -= colour.length;
        }

        //TODO set as string builder

        return colour[index%colour.length] + LocalTime.now().format(myTimeFormat)
                + " " + LocalDate.now().format(myDateFormat)
                +" in application: " + record.getSourceClassName()
                + "\n" + colour[(index+1)%colour.length] + record.getLevel()
                +" " + record.getMessage()
                + "\n";
    }
}
/*
Color Name 	Color code 	Background Color 	Background Color code
BLACK 	\u001B[30m 	BLACK_BACKGROUND 	\u001B[40m
RED 	\u001B[31m 	RED_BACKGROUND 	    \u001B[41m
GREEN 	\u001B[32m 	GREEN_BACKGROUND 	\u001B[42m
YELLOW 	\u001B[33m 	YELLOW_BACKGROUND 	\u001B[43m
BLUE 	\u001B[34m 	BLUE_BACKGROUND 	\u001B[44m
PURPLE 	\u001B[35m 	PURPLE_BACKGROUND 	\u001B[45m
CYAN 	\u001B[36m 	CYAN_BACKGROUND 	\u001B[46m
WHITE 	\u001B[37m 	WHITE_BACKGROUND 	\u001B[47m
 */
