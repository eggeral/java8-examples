package b_stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PartitioningAndGrouping {
    static class Flight {
        int passengers;
        String name;

        Flight(String name, int passengers) {
            this.name = name;
            this.passengers = passengers;
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "passengers=" + passengers +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(
                new Flight("OS201", 65), new Flight("OS202", 87), new Flight("LH4567", 198));

        Map<String, List<Flight>> carrierToFlight = flights.stream()
                .collect(Collectors.groupingBy(f -> f.name.substring(0,2)));
        System.out.println(carrierToFlight);
        System.out.println("---");

        Map<Boolean, List<Flight>> flightsWithMoreThan80Passengers = flights.stream()
                .collect(Collectors.partitioningBy(f -> f.passengers > 80));
        System.out.println(flightsWithMoreThan80Passengers);
        System.out.println("---");

        Map<String, String> carrierToFlightStrings = flights.stream()
                .collect(Collectors.groupingBy(f -> f.name.substring(0, 2),
                        Collectors.mapping(f -> f.name, Collectors.joining(","))));
        System.out.println(carrierToFlightStrings);
        System.out.println("---");

        Map<String, IntSummaryStatistics> passengerStat = flights.stream()
                .collect(Collectors.groupingBy(f -> f.name.substring(0, 2),
                        Collectors.summarizingInt(f -> f.passengers)));
        System.out.println(passengerStat);
        System.out.println("---");

    }
}
