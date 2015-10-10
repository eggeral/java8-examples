package c_time;

import com.sun.tools.internal.xjc.runtime.ZeroOneBooleanAdapter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

class InstantClass {
    public static void main(String[] args) {
        //Instant represents the current machine time in nano seconds
        Instant now = Instant.now();
        System.out.println(now);

        // Start of the counter
        Instant start = Instant.ofEpochMilli(0);
        System.out.println(start);
        start = Instant.EPOCH;
        System.out.println(start);

        // Walking the time line
        System.out.println(Instant.now().plus(1, ChronoUnit.HOURS));
        System.out.println(Instant.now().isBefore(Instant.now().minusSeconds(1)));
        System.out.println(Instant.now().isAfter(Instant.now().minusSeconds(1)));

        // Parse only works with ISO string format!
        System.out.println(Instant.parse("1974-04-01T04:00:00.000Z").until(Instant.now(), ChronoUnit.DAYS));

        // Instant does not map directly to the human time concept. A time zone or offset is needed.
        System.out.println(ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        // ZonedDateTime directly maps to an instant.
        System.out.println(ZonedDateTime.now(ZoneId.of("CET", ZoneId.SHORT_IDS)).toInstant());

    }
}
