package c_time;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class Formatting {

    private static DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        ZonedDateTime departure = ZonedDateTime.now();
        LocalTime arrival = LocalTime.MIDNIGHT;

        System.out.println(departure.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(departure.format(myFormat));

        System.out.println(arrival.format(timeFormat));

    }
}
