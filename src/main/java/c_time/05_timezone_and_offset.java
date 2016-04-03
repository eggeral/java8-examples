package c_time;

import java.time.*;

class TimeZoneAndOffset {
    public static void main(String[] args) {
        // ZoneId
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
        System.out.println("---");

        LocalDateTime departure = LocalDateTime.of(2015, Month.OCTOBER, 1, 10, 30);
        LocalDateTime landing = departure.plusHours(9).plusMinutes(25);

        // ZonedDateTime (deals with daylight saving time etc.
        ZonedDateTime zonedDeparture = ZonedDateTime.of(departure, ZoneId.of("Europe/Sidney"));
        ZonedDateTime zonedLanding = ZonedDateTime.of(landing, ZoneId.of("America/Ankorage"));

        System.out.println(zonedDeparture);
        System.out.println(zonedLanding); // hm that's wrong :-(

        zonedLanding = zonedDeparture.plusHours(9).plusMinutes(25).withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zonedLanding);
        System.out.println(ZoneId.of("America/New_York").getRules().getDaylightSavings(zonedLanding.toInstant()));
        System.out.println("---");

        // OffsetDateTime (just offset)
        OffsetDateTime offsetDeparture = OffsetDateTime.of(departure, ZoneOffset.of("-08:00"));
        System.out.println(offsetDeparture);
        System.out.println(ZoneId.of("Europe/Vienna").getRules().getOffset(LocalDateTime.of(2015, Month.SEPTEMBER, 1, 0, 0)));
        System.out.println(ZoneId.of("Europe/Vienna").getRules().getOffset(LocalDateTime.of(2015, Month.NOVEMBER, 1, 0, 0)));
        System.out.println("---");

        // OffsetTime (need to track offset to GWT but not date is needed.
        OffsetTime  offsetTime = OffsetTime.of(LocalTime.of(10, 20), ZoneOffset.of("+06:00"));
        System.out.println(offsetTime);
        System.out.println(offsetTime.atDate(LocalDate.of(2016, Month.APRIL, 2)));


    }
}
