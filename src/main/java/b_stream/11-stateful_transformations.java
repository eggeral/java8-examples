package b_stream;

import java.util.Comparator;
import java.util.stream.Stream;

class StatefulTransformations {
    public static void main(String[] args) {
        // The stream operations until now always worked on a single element without knowing about
        // the other elements in the stream

        // Find all airlines in a stream of flights.
        Stream<String> flights = Stream.of("OS201", "OS202", "LH4547", "LH1234", "4U435");
        flights.map(x -> x.substring(0, 2)).distinct().forEach(System.out::println);
        System.out.println("-----");

        // Sort flights by flight number
        flights = Stream.of("OS201", "OS202", "LH4547", "LH1234", "4U435");
        flights.map(x -> Integer.parseInt(x.substring(2))).sorted().forEach(System.out::println);
        System.out.println("-----");

        // But we want to get back the whole flight number!
        flights = Stream.of("OS201", "OS202", "LH4547", "LH1234", "4U435");
        flights.sorted(Comparator.comparing(x -> Integer.parseInt(x.substring(2)))).forEach(System.out::println);
        System.out.println("-----");

    }
}
