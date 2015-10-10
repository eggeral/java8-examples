package test;

import java.time.LocalDate;
import java.time.Month;

public class LeapYearTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, Month.FEBRUARY, 29);
        System.out.println(date);
        System.out.println(date.plusYears(4));
        System.out.println(date.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
    }
}
