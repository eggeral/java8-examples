package c_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class TemporalAdjustersClass {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("First day of next month: " + now.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("First Friday in month: " + now.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)));

        // Custom temporal adjusters.
        TemporalAdjuster fridayBeforeThe15thOfAMonth = temporal -> {
            LocalDate date = LocalDate.from(temporal).withDayOfMonth(15);
            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            return temporal.with(date);
        };
        System.out.println("Friday before the 15th of a month: " + now.with(fridayBeforeThe15thOfAMonth));

        TemporalAdjuster secondSundayOfNextMonth = temporal -> {
            LocalDate date = LocalDate.from(temporal).plusMonths(1);
            date = date.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SATURDAY));
            return temporal.with(date);
        };
        System.out.println("Second sunday of next month: " + now.with(secondSundayOfNextMonth));

    }
}
