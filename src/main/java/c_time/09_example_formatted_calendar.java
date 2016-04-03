package c_time;

import java.time.Month;
import java.time.YearMonth;

class FormattedCalendar {
    public static void main(String[] args) {
        YearMonth yearMonth = YearMonth.of(2016, Month.FEBRUARY);
        System.out.println("\t M\t D\t M\t D\t F\t S\t S");

        int column = yearMonth.atDay(1).getDayOfWeek().getValue();
        for (int i = 0; i < column - 1; i++) {
            System.out.print("\t");
        }
        for (int currentDay = 1; currentDay <= yearMonth.lengthOfMonth(); currentDay++) {
            System.out.print(String.format("\t%02d", currentDay));
            if (column % 7 == 0)
                System.out.println();
            column++;

        }

    }
}
