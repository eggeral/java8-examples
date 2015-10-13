package c_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

class Legacy {
    public static void main(String[] args) {
        System.out.println(GregorianCalendar.getInstance());
        System.out.println(GregorianCalendar.getInstance().toInstant());
        System.out.println(new GregorianCalendar().toZonedDateTime());
        System.out.println(GregorianCalendar.from(ZonedDateTime.now()));
        System.out.println("---");

        System.out.println(new Date());
        System.out.println(new Date().toInstant());
        System.out.println(Date.from(Instant.EPOCH));
        System.out.println("---");

        System.out.println(TimeZone.getTimeZone("Europe/Vienna"));
        System.out.println(TimeZone.getTimeZone(ZoneId.of("Europe/Vienna")));
        System.out.println(TimeZone.getTimeZone("Europe/Vienna").toZoneId());
    }
}
