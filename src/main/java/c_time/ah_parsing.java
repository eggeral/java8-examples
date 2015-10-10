package c_time;

import static java.time.temporal.ChronoField.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

class Parsing {

    private static DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void main(String[] args) {
        // DateTimeFormatter has some common formats predefined.
        System.out.println(LocalDate.parse("2015-01-01", DateTimeFormatter.ISO_LOCAL_DATE));

        // You may define your own DateTimeFormatter. Use static final fields to store them.
        System.out.println(LocalDate.parse("2015/01/01 23:05:05", myFormat));

        // DateFormatterBuilder is a more type save way to construct
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(HOUR_OF_DAY, 2)
                .appendLiteral(':')
                .appendValue(MINUTE_OF_HOUR, 2)
                .optionalStart()
                .appendLiteral(':')
                .appendValue(SECOND_OF_MINUTE, 2)
                .toFormatter();

        System.out.println(LocalTime.parse("10:20", formatter));
    }
}
