package b_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Why Streams?
//
// Run operations on items of a collection without specifying how to walk through the collection
//
// Iterators are hard to parallelize
//
// Enable a more functional way of programming leading to code which is better readable.  ( If used with caution! )



class StreamsVsIteration {
    public static void main(String[] args) {
        List<String> flights = Arrays.asList("OS201", "OS203", "LH4005", "LH1234", "4U8056");
        System.out.println(flights);

        // Get all AUA flights
        List<String> auaFlights = new ArrayList<>();
        for (String flight : flights) {
            if (flight.startsWith("OS"))
                auaFlights.add(flight);
        }
        System.out.println(auaFlights);

        //Streams get all Lufthansa flights
        flights.stream().filter(entry -> entry.startsWith("LH")).forEach(System.out::println);
    }
}
