package e_other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Comparing {
    static class Flight {
        private final String name;
        private final int passengers;

        Flight(String name, int passengers) {
            this.name = name;
            this.passengers = passengers;
        }
    }

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("OS201", 34));
        flights.add(new Flight("OS202", 123));
        flights.add(new Flight("FH2344", 78));

        Collections.sort(flights, Comparator.comparing(flight -> flight.passengers));
        Collections.sort(flights, Comparator.<Flight, Integer>comparing(flight -> flight.passengers)
                .thenComparing(flight -> flight.name));
    }
}
