package c_time;

import java.time.*;

class ClockClass {
    public static void main(String[] args) throws InterruptedException {
        // now() methods use the system clock!
        System.out.println(LocalDateTime.now());

        // But you may use a different one
        System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));
        System.out.println(LocalDateTime.now(Clock.systemUTC()));
        System.out.println(LocalDateTime.now(Clock.offset(Clock.systemUTC(), Duration.ofMinutes(30))));
        System.out.println("---");
        Clock fixedClock = Clock.fixed(Instant.EPOCH, ZoneId.of("Europe/Vienna"));
        System.out.println(LocalDateTime.now(fixedClock));
        Thread.sleep(1000);
        System.out.println(LocalDateTime.now(fixedClock));

        System.out.println("---");
        Clock secondTickClock = Clock.tickSeconds(ZoneId.systemDefault());
        System.out.println(LocalDateTime.now(secondTickClock));
        Thread.sleep(600);
        System.out.println(LocalDateTime.now(secondTickClock));
        Thread.sleep(600);
        System.out.println(LocalDateTime.now(secondTickClock));


    }
}
