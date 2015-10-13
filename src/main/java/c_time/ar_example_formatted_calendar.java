package c_time;

import java.time.Month;
import java.time.YearMonth;

class FormattedCalendar {
    public static void main(String[] args) {
        YearMonth yearMonth = YearMonth.of(2015, Month.JUNE);
        System.out.println("\tM\tD\tM\tD\tF\tS\tS");

        int column = yearMonth.atDay(1).getDayOfWeek().getValue();
        for (int i = 0; i < column - 1; i++) {
            System.out.print("\t");
        }

        for (int currentDay = 1; currentDay <= yearMonth.lengthOfMonth(); currentDay++) {
            System.out.print("\t" + currentDay);
            if (column % 7 == 0)
                System.out.println();
            column ++;
        }

    }
}
