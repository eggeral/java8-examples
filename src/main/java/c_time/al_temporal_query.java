package c_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.util.HashMap;
import java.util.Map;

class TemporalQueryClass {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().query(TemporalQueries.precision()));
        System.out.println(LocalDateTime.now().query(TemporalQueries.localTime()));
        System.out.println(LocalDateTime.now().query(TemporalQueries.zone()));
        System.out.println("---");

        //Custom queries
        Map<LocalDate, String> booked = new HashMap<LocalDate, String>() {{
            put(LocalDate.parse("2015-10-06"), "Ludwigsburg");
            put(LocalDate.parse("2015-10-07"), "Ludwigsburg");
            put(LocalDate.parse("2015-10-13"), "Ludwigsburg");
            put(LocalDate.parse("2015-10-14"), "Ludwigsburg");
            put(LocalDate.parse("2015-11-13"), "Salzburg");
        }};

        TemporalQuery<Boolean> isBooked = temporal -> {
            LocalDate date = LocalDate.from(temporal);
            return booked.containsKey(date);
        };

        System.out.println(LocalDateTime.parse("2015-10-01T10:25").query(isBooked));
        System.out.println(LocalDateTime.parse("2015-10-14T11:25").query(isBooked));

    }
}
