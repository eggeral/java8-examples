package b_stream;

import java.util.*;

class Reductions {
    static class Flight {
        String name;
        int passengers;

        Flight(String name, int passengers) {
            this.name = name;
            this.passengers = passengers;
        }
    }

    public static void main(String[] args) {
        // Reduction operations are terminal operations creating a final result for the stream operations.
        List<Flight> flights = Arrays.asList(new Flight("OS201", 54), new Flight("OS202", 9),
                new Flight("LH3456", 104), new Flight("LH9876", 78), new Flight("4U234", 36));

        System.out.println("Count OS flights");
        System.out.println(flights.stream().filter(x -> x.name.startsWith("OS")).count());
        System.out.println("---");

        System.out.println("Total passengers of FH flights");
        System.out.println(flights.stream().filter(x -> x.name.startsWith("OS")).mapToInt(x -> x.passengers).sum());
        System.out.println("---");

        System.out.println("Average number of passengers of 4U flights");
        System.out.println(flights.stream().filter(x -> x.name.startsWith("4U")).mapToInt(x -> x.passengers).average());
        System.out.println("---");

        System.out.println("Max number of passengers");
        System.out.println(flights.stream().mapToInt(x -> x.passengers).max());
        System.out.println("---");

        // Optional is safer than returning null. Means something is there or not.
        OptionalInt max = flights.stream().mapToInt(x -> x.passengers).max();
        if (max.isPresent())
            System.out.println("Maximum number of passengers: " + max.getAsInt());
        else
            System.out.println("No maximum number of passengers found.");
        // This is not the ideal way of using Optional. Next example shows a better way.

        System.out.println("Flight with min passengers");
        System.out.println(flights.stream().min(Comparator.comparing(x -> x.passengers)).get().name);
        System.out.println("---");

        System.out.println("Find the first flight containing more than 10 passengers");
        System.out.println(flights.stream().filter(x -> x.passengers > 10).findFirst().get().name);
        System.out.println("---");

        System.out.println("Find any flight containing less than 10 passengers");
        // This makes sense when we work with parallel streams (later!)
        System.out.println(flights.stream().filter(x -> x.passengers < 10).findAny().get().name);
        System.out.println("---");

        System.out.println("Is there any flight with more than 10 passengers?");
        System.out.println(flights.stream().anyMatch(x -> x.passengers > 10));
        System.out.println("---");

        System.out.println("Have all flights more than 10 passengers?");
        System.out.println(flights.stream().allMatch(x -> x.passengers > 10));
        System.out.println("---");

        // Has one flight more than 10 passengers?
        System.out.println("Have all flight not less than 10 passengers?");
        System.out.println(flights.stream().noneMatch(x -> x.passengers < 10));
        System.out.println("---");

    }
}
