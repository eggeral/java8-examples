package c_time;

import java.time.*;

class HumanTimeMachineTime {
    public static void main(String[] args) {
        // Human time in terms of year month day
        LocalDate birthDay = LocalDate.of(1974,4,1);
        System.out.println(birthDay);

        // Machine time in terms of seconds since 1970
        Instant now = Instant.now();
        System.out.println(now);

        Instant birth = Instant.parse("1974-04-01T00:00:00.00Z");
        System.out.println(birth);

        // Human time mapped to machine time

        // First we need a time for the date
        LocalDateTime birthDayWithTime = birthDay.atStartOfDay();

        // Then we need a time zone.
        System.out.println(birthDayWithTime.toInstant(ZoneOffset.UTC));
        System.out.println(birthDayWithTime.atZone(ZoneId.of("Europe/Vienna")));
        System.out.println(birthDayWithTime.atZone(ZoneId.of("Europe/Vienna")).toInstant());
    }
}
