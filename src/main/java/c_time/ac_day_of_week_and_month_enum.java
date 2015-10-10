package c_time;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

class DayOfWeekAndMonthEnum {
    public static void main(String[] args) {
        // Week
        DayOfWeek day = DayOfWeek.MONDAY;
        System.out.println(day);
        System.out.println(day.plus(3));
        System.out.println(day.getDisplayName(TextStyle.FULL, Locale.GERMAN));
        System.out.println(day.getDisplayName(TextStyle.FULL, Locale.US));
        System.out.println(day.getDisplayName(TextStyle.SHORT, Locale.GERMAN));

        System.out.println("---");

        // Month
        System.out.println(Month.APRIL);
        System.out.println(Month.APRIL.getDisplayName(TextStyle.FULL, Locale.CHINESE));
        System.out.println(Month.APRIL.maxLength());
        System.out.println(Month.FEBRUARY.maxLength());
        System.out.println(Month.MARCH.firstMonthOfQuarter());
        System.out.println(Month.FEBRUARY.firstDayOfYear(false));
        System.out.println(Month.APRIL.firstDayOfYear(false));
        System.out.println(Month.APRIL.plus(4));
    }
}
