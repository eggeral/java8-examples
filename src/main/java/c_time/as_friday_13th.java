package c_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

class Friday13th {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2015, 01, 01);
        Period period = Period.ofMonths(500);

        LocalDate current = start.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while(current.isBefore(start.plus(period))) {
            if (current.getDayOfMonth() == 13)
                System.out.println(current);
            current = current.plusWeeks(1);
        }
    }
}
