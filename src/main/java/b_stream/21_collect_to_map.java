package b_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CollectToMap {
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
        Map<String, Integer> nameToPassengers = flights.stream()
                .collect(Collectors.toMap(f -> f.name, f -> f.passengers));
        System.out.println(nameToPassengers);
        System.out.println("---");

        Map<String, Flight> nameToFlight = flights.stream()
                .collect(Collectors.toMap(f -> f.name, Function.identity()));
        System.out.println(nameToFlight);
        System.out.println("---");

        // IllegalState: Duplicate key!
        // Map<String, Flight> carrierToFlight = flights.stream()
        // .collect(Collectors.toMap(f -> f.name.substring(0,2), Function.identity()));
        Map<String, List<Flight>> carrierToFlight = flights.stream().collect(
                Collectors.toMap(f -> f.name.substring(0, 2),
                        Arrays::asList, // A list with one value!
                        (lhs, rhs) -> Arrays.asList(
                                Stream.concat(lhs.stream(), rhs.stream()).toArray(Flight[]::new)))); //Resolve duplicate key
        System.out.println(carrierToFlight);
        System.out.println("---");
    }
}
