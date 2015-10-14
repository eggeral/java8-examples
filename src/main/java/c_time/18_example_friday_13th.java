package c_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

class Friday13th {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2015, 01, 01);
        Period period = Period.ofMonths(12);

        // Using day of month. This does not work if the start day is after 13th. Depends
        // of what I want to achieve.
        // Could check for previous ... etc
        LocalDate current = start.withDayOfMonth(13);
        while(current.isBefore(start.plus(period))) {
            if (current.getDayOfWeek().equals(DayOfWeek.FRIDAY))
                System.out.println(current);
            current = current.plusMonths(1);
        }

        System.out.println("=======");

        // Implementation based on weeks
        current = start.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while(current.isBefore(start.plus(period))) {
            if (current.getDayOfMonth() == 13)
                System.out.println(current);
            current = current.plusWeeks(1);
        }
    }
}
