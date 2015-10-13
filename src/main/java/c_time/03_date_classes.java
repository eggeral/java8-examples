package c_time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

class DateClasses {
    public static void main(String[] args) {
        // LocalDate represents year-month-day in ISO calendar without time
        LocalDate localDate = LocalDate.of(2015, Month.OCTOBER, 10);
        System.out.println(localDate);
        LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextMonday);
        System.out.println(localDate.getDayOfWeek());
        System.out.println("---");

        // YearMonth represents a month of a year
        System.out.println(YearMonth.of(2015, Month.APRIL));
        System.out.println(YearMonth.of(2015, Month.FEBRUARY).lengthOfMonth());
        System.out.println(YearMonth.of(2016, Month.FEBRUARY).lengthOfMonth());
        System.out.println(YearMonth.of(2016, Month.FEBRUARY).atEndOfMonth());
        System.out.println(YearMonth.of(2015, Month.OCTOBER).atDay(10));
        System.out.println("---");

        // MonthDay
        System.out.println(MonthDay.of(Month.APRIL, 1));
        System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(2015));
        System.out.println(MonthDay.of(Month.FEBRUARY, 29).isValidYear(2016));
        System.out.println(MonthDay.of(Month.APRIL, 10).atYear(2016));

        // Year
        System.out.println(Year.of(2016));
        System.out.println(Year.of(2015).isLeap());
        System.out.println(Year.of(2016).isLeap());
        System.out.println(Year.of(2015).atMonth(Month.APRIL));

    }
}
