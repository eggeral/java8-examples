package c_time;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateIsBad {
    static class Flight {
        Date startDate;

        Flight(Date startDate) {
            this.startDate = startDate;
        }
    }

    public static void main(String[] args) {
        // Date is mutable
        Flight flight = new Flight(new Date(2015, 1, 12, 23, 59, 22));
        Date startDate = flight.startDate;
        startDate.setTime(100); // you probably don't want someone from outside changing that

        // Month is zero based day is not
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println(format.format(new Date(2015, 1, 23))); // this is actually february!

        // Year starts with 0 at 1900
        System.out.println(new Date().getYear());

        // Leap seconds are fun

        // The new time API defines exactly how Java handles leap seconds:
        // the Java Time-Scale shall closely match the underlying international civil time scale;
        // the Java Time-Scale shall exactly match the international civil time scale at noon each day;
        // the Java Time-Scale shall have a precisely-defined relationship to the international civil time scale.
        // On days that do have a leap second, the leap second is spread equally over the last 1000 seconds of
        // the day, maintaining the appearance of exactly 86400 seconds per day.

        // No representation for dates without timezone, durations, intervals, periods

    }
}
