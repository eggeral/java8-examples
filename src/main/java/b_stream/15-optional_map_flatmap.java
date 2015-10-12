package b_stream;

import java.util.Optional;

class OptionalMapAndFlatMap {
    static class Flight {
        private String name;

        Flight(String name) {
            this.name = name;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }
    }

    public static Optional<String> osFlightName(String flightName) {
        if (flightName.startsWith("OS"))
            return Optional.of(flightName + " - AUA");
        return Optional.empty();
    }

    public static void main(String[] args) {
        // Optional can be seen as a stream mit 0 or 1 element.

        // You may map the optional value to something new
        Optional<String> flightName = Optional.of(new Flight("OS201")).map(x -> x.name);
        System.out.println(flightName.get());
        System.out.println("---");

        flightName = Optional.<Flight> empty().map(x -> x.name);
        System.out.println(flightName.isPresent());
        System.out.println("---");

        // flatMap helps composing functions on Optional types

        // Does not work because Flight::getName returns an Optional
        Optional<Optional<String>> flightOptional = Optional.of(new Flight("OS201")).map(Flight::getName);

        flightName = Optional.of(new Flight("OS201")).flatMap(Flight::getName).flatMap(OptionalMapAndFlatMap::osFlightName);
        System.out.println(flightName.get());
        System.out.println("---");


    }
}
