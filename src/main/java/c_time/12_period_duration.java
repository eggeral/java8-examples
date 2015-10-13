package c_time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

class PeriodAndDuration {
    public static void main(String[] args) {
        // Duration is based on machine time. A day is always 24 hours
        System.out.println(Duration.between(Instant.now(), Instant.now().plusSeconds(86400)));
        System.out.println(Duration.between(Instant.now(), Instant.now().plusSeconds(86400)).toHours());
        System.out.println(Instant.now().plus(Duration.ofDays(1)));

        // ChronoUnit can be used to calculate durations too;
        System.out.println(ChronoUnit.DAYS.between(Instant.EPOCH, Instant.now()));

        // Period is used to define periods on human time
        System.out.println(Period.between(LocalDate.now(), LocalDate.parse("2015-12-24")));
        System.out.println(Period.between(LocalDate.now(), LocalDate.parse("2015-12-24")).getDays()); //careful!!!

        System.out.println("---");
        // Period takes into account daylight saving time. Duration does not!
        ZonedDateTime midnightAtLastSundayInOctober =
                LocalDate.of(2015, 10, 1).with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY))
                .atStartOfDay(ZoneId.of("Europe/Vienna"));

        System.out.println(midnightAtLastSundayInOctober);
        System.out.println(midnightAtLastSundayInOctober.plus(Period.ofDays(1)));
        System.out.println(midnightAtLastSundayInOctober.plus(Duration.ofDays(1)));
        System.out.println(
                Duration.between(midnightAtLastSundayInOctober, midnightAtLastSundayInOctober.plus(Period.ofDays(1))));

    }
}
