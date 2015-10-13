package b_stream;

import java.util.stream.Stream;

class FilterMapFlatMap {
    static class Flight {
        String number;
        Stream<String> passengers;
        public Flight(String number) {
            this.number = number;
        }
    }

    public static void main(String[] args) {
        // Transform the elements of a stream into other elements

        // Filter elements of the stream by a predicate
        Stream.of("aaaa", "bb", "ccccc").filter(x -> x.length() > 2).forEach(System.out::print);
        System.out.println();

        // Map elements to new elements
        Stream.of("aaaa", "bb", "ccccc").map(x -> x.length()).forEach(System.out::print);
        System.out.println();

        Stream.of(new Flight("OS201"),new Flight("OS202"), new Flight("LH4567")).map(flight -> flight.number).forEach(System.out::print);
        System.out.println();

        // FlatMap streams of streams (Monad)
        Flight flightOs201 = new Flight("OS201");
        flightOs201.passengers = Stream.of("Muster", "Man");
        Flight flightOs204 = new Flight("OS204");
        flightOs204.passengers = Stream.of("Max", "Hofer", "Huber");
        Flight flightFh4567 = new Flight("FH4567");
        flightFh4567.passengers = Stream.of("Mair");

        Stream<Stream<String>> passengerStreams = Stream.of(flightOs201, flightOs204, flightFh4567).map(flight -> flight.passengers);
        passengerStreams.forEach(System.out::print);
        System.out.println();

        Stream<String> passengers = Stream.of(flightOs201, flightOs204, flightFh4567).flatMap(flight -> flight.passengers);
        passengers.forEach(System.out::print);
        System.out.println();



    }
}
