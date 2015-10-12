package a_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FilterListWithoutLambda {

    public static void main(String[] args) {
        List<String> flights = Arrays.asList("OS201", "OS202", "LH4532", "4U234");
        System.out.println(flights);

        // Filter the flights.
        List<String> filtered = allAuaFlights(flights);
        System.out.println(filtered);

        filtered = allLufthansaFlights(flights);
        System.out.println(filtered);

        // In order not to have duplicate code you might add the prefix as a parameter,
        // but there is an even better way.

    }

    private static List<String> allAuaFlights(List<String> flights) {
        List<String> auaFlights = new ArrayList<>();
        for (String flight : flights) {
            if (flight.startsWith("OS"))
                auaFlights.add(flight);
        }
        return auaFlights;
    }

    private static List<String> allLufthansaFlights(List<String> flights) {
        List<String> auaFlights = new ArrayList<>();
        for (String flight : flights) {
            if (flight.startsWith("LH"))
                auaFlights.add(flight);
        }
        return auaFlights;
    }

}
