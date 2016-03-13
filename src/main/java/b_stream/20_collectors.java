package b_stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Create a list/map/... from a stream (or a single value like a string ;-)
// -> reduce is a special kind of collect.
class CollectorsUsage {
    static class Flight {
        int passengers;
        Flight(int passengers) {
            this.passengers = passengers;
        }
    }

    public static void main(String[] args) {
        String[] flightArray= Stream.of("OS201", "OS202", "LH4567").toArray(String[]::new);
        List<String> flightList = Stream.of("OS201", "OS202", "LH4567").collect(Collectors.toList());
        TreeSet<String> flightSet = Stream.of("OS201", "OS202", "LH4567").collect(Collectors.toCollection(TreeSet::new));

        String joined = Stream.of("OS201", "OS202", "LH4567").collect(Collectors.joining());
        System.out.println(joined);
        joined = Stream.of("OS201", "OS202", "LH4567").collect(Collectors.joining(", "));
        System.out.println(joined);
        System.out.println("--");

        // Sum of all passengers.
        IntSummaryStatistics passengers = Stream.of(new Flight(41), new Flight(61))
                .collect(Collectors.summarizingInt(x -> x.passengers));
        System.out.println(passengers);
        System.out.println("--");

        Collector<String, StringBuilder, String> myCollector = new Collector<String, StringBuilder, String>() {
            // Function which supplies the identity value
            @Override
            public Supplier supplier() {
                return () -> new StringBuilder();
            }

            // Add a value to existing collection
            @Override
            public BiConsumer<StringBuilder, String> accumulator() {
                return (current, next) -> current.append(next).append(" - ");
            }

            // Combine two collections
            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return (lhs, rhs) -> lhs.append(rhs);
            }

            // Function to run after everything was collected
            @Override
            public Function<StringBuilder, String> finisher() {
                return result -> result.toString();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return EnumSet.of(Collector.Characteristics.CONCURRENT,
                        Collector.Characteristics.UNORDERED);
            }
        };

        joined = Stream.of("OS201", "OS202", "LH4567").collect(myCollector);
        System.out.println(joined);
        System.out.println("--");

    }
}
