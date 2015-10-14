package c_time;

import java.time.LocalDate;
import java.time.Month;

class AddOneYear {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, Month.FEBRUARY, 29);
        System.out.println(date.plusYears(4));
        System.out.println(date.plusMonths(12));
        System.out.println(date.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
        System.out.println(date.plusMonths(12).plusMonths(12).plusMonths(12).plusMonths(12));

    }
}
