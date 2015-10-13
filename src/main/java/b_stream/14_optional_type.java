package b_stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

class OptionalType {
    public static void main(String[] args) {
        // Optional represents an object or no object

        // Other APIs do that using null
        Map<Integer, String> flights = new HashMap<>();
        String flight = flights.get(10);
        // flight.contains("bla"); // null pointer exception!

        // so we always have to check for null
        if (flight != null && flight.equals("playground")) // null safe check ;-)
            System.out.println("This is a test flight");

        // Null is evil. Optional is better!
        Optional<String> flightOptional = Stream.<String> empty().findAny();
        // flightOptional.get().contains("bla"); // Well you have to use it right!!

        // We also have to check for existence here.
        // So how does this help?
        if (flightOptional.isPresent() && flight.equals("playground"))
            System.out.println("This is a test flight");

        // Try this
        flightOptional.ifPresent(x -> {
            if (x.equals("playground"))
                System.out.println("This is a test flight");
        });

        System.out.println("---");
        // Or even better
        flightOptional = Optional.of("playground");
        flightOptional.filter(x -> x.equals("playground")).ifPresent(System.out::println);
        // Optionals can be consumed more than once!!!
        System.out.println(flightOptional.filter(x -> x.equals("test1")).isPresent());
        System.out.println("---");

        // Get an alternative if the optional is empty
        flightOptional = Stream.<String> empty().findAny();
        System.out.println(flightOptional.orElse("empty"));
        System.out.println(flightOptional.orElseGet(() -> "this is empty"));
        //flightOptional.orElseThrow(() -> new IllegalStateException("Value is empty"));

    }
}
