package b_stream;

import java.util.Optional;

class OptionalTypeCreation {
    public static void main(String[] args) {
        Optional<String> flight = Optional.empty();
        System.out.println(flight.isPresent());
        System.out.println("---");

        flight = Optional.of("test flight");
        System.out.println(flight.get());
        System.out.println("---");

        String test = null;
        flight = Optional.ofNullable(test);
        System.out.println(flight.isPresent());
        System.out.println("---");

    }
}
