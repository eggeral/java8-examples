package a_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class FilterList {

    public static void main(String[] args) {
        List<String> flights = Arrays.asList("OS201", "OS202", "LH4532", "4U234");
        System.out.println(flights);

        // Filter the flights.
        List<String> auaFlights = filter(flights, flight -> flight.startsWith("OS"));
        System.out.println(auaFlights);

        List<String> lufthansaFlights = filter(flights, flight -> flight.startsWith("LH"));
        System.out.println(lufthansaFlights);

        // now we can even define totally different queries and still keep the basic method

        List<String> allFlightNumberLargerThan222 = filter(flights, flight -> Integer.parseInt(flight.substring(2)) > 222);
        System.out.println(allFlightNumberLargerThan222);

    }

    private static List<String> filter(List<String> flights, Predicate<String> predicate) {
        List<String> auaFlights = new ArrayList<>();
        for (String flight : flights) {
            if (predicate.test(flight))
                auaFlights.add(flight);
        }
        return auaFlights;
    }

}
