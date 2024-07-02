package com.sparta.spartios.logging;

import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatterReadable extends Formatter {
    private static final String[] colour = {"\u001B[38;2;255;30;38m ","\u001B[38;2;255;148;30m ","\u001B[38;2;255;255;0m "
            ,"\u001B[38;2;6;189;0m ","\u001B[38;2;0;26;152m ","\u001B[38;2;118;0;136m "
            ,"\u001B[38;2;0;0;0m ", "\u001B[38;2;96;56;20m "
            ,"\u001B[38;2;117;213;235m ","\u001B[38;2;253;175;199m ","\u001B[38;2;255;255;255m "};
    private static int index = colour.length-1;
    @Override
    public String format(LogRecord record) {
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd MMM");
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        index += 1;
        if (index > colour.length + 1){
            index -= colour.length;
        }
        //TODO set as string builder
        return colour[index%colour.length]
                +" " + record.getMessage()
                + "\n";
    }
}
