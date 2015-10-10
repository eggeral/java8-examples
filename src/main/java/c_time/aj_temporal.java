package c_time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.*;

class TemporalPackage {
    public static void main(String[] args) {
        // These are low level interfaces. Not for every day use!
        Temporal instant = Instant.now();
        System.out.println(instant.isSupported(ChronoUnit.DECADES));
        System.out.println(instant.isSupported(ChronoUnit.SECONDS));
        System.out.println(instant.isSupported(ChronoField.DAY_OF_MONTH));
        System.out.println("---");

        Temporal localDate = LocalDate.now();
        System.out.println(localDate.isSupported(ChronoUnit.DECADES));
        System.out.println(localDate.isSupported(ChronoUnit.SECONDS));
        System.out.println(localDate.isSupported(ChronoField.DAY_OF_MONTH));
        System.out.println(localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
        System.out.println(localDate.get(WeekFields.ISO.dayOfWeek()));
        System.out.println("---");

    }
}
