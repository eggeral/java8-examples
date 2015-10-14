package b_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ParallelWordCounting {

    public static void main(String[] args) throws IOException {
        Instant start = Instant.now();
        Stream<String> lines = Files.lines(Paths.get("frankenstein.txt"));
        System.out.println(lines.flatMap(l -> Arrays.stream(l.split("[\\P{L}]+")))
                .collect(Collectors.groupingBy(w -> w.length(), Collectors.counting())));
        System.out.println(Duration.between(start, Instant.now()));

        start = Instant.now();
        lines = Files.lines(Paths.get("frankenstein.txt"));
        System.out.println(lines.flatMap(l -> Arrays.stream(l.split("[\\P{L}]+")))
                .collect(Collectors.groupingBy(w -> w.length(), Collectors.counting())));
        System.out.println(Duration.between(start, Instant.now()));

        start = Instant.now();
        lines = Files.lines(Paths.get("frankenstein.txt"));
        System.out.println(lines.parallel().flatMap(l -> Arrays.stream(l.split("[\\P{L}]+")))
                .collect(Collectors.groupingBy(w -> w.length(), Collectors.counting())));
        System.out.println(Duration.between(start, Instant.now()));
    }
}
