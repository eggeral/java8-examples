package b_stream;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

class ParallelStreams {
    public static void main(String[] args) {
        List<String> flights = Arrays.asList("OS201", "OS202", "LH4567", "LH2345", "LH5442", "4U4343", "4U452");

        Instant start = Instant.now();
        String flightsString = flights.stream().reduce("", ParallelStreams::longLastingAccumulator);
        Duration duration = Duration.between(start, Instant.now());
        System.out.println(flightsString);
        System.out.println(duration);
        System.out.println("---");

        start = Instant.now();
        flightsString = flights.parallelStream().reduce("", ParallelStreams::longLastingAccumulator);
        duration = Duration.between(start, Instant.now());
        System.out.println(flightsString);
        System.out.println(duration);
        System.out.println("---");

        // Selecting the right identity element is important!
        System.out.println(flights.stream().reduce("**", (current, next) -> current + next));
        System.out.println("---");
        System.out.println(flights.parallelStream().reduce("**", (current, next) -> current + next));
        System.out.println("---");

    }

    private static String longLastingAccumulator(String current, String next) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return current + next;
    }

}
