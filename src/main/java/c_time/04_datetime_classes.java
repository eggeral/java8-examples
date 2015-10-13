package c_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

class DateTimeClasses {
    public static void main(String[] args) {
        // LocalTime represents human time
        System.out.println(LocalTime.of(23, 45));
        System.out.println(LocalTime.NOON);

        System.out.println("---");
        // LocalDateTime
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.of(2015, Month.DECEMBER, 24).atTime(23, 35, 10));
        System.out.println(LocalTime.now().atDate(LocalDate.of(1900, Month.APRIL, 1)));
        System.out.println(LocalDateTime.now().plusMonths(6));
    }
}
