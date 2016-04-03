package b_stream;

import java.util.stream.Stream;

class MutableReductionCollect {
    public static void main(String[] args) {


        // A lot of string copies ahead.
        String flights = Stream.of("OS201", "OS202", "LH4567").reduce(
                "", (current, next) -> current + ", " + next);

        System.out.println(flights);
        System.out.println("----");

        // Works but a StringBuilder would be better.
        StringBuilder flightsBuilder = Stream.of("OS201", "OS202", "LH4567")
                .collect(
                        () -> new StringBuilder(), // identity
                        (current, next) -> current.append(", ").append(next), // add one element to an existing result
                        (lhs, rhs) -> lhs.append(rhs)// combine two results (two StringBuffers in that case.
                );
        System.out.println(flightsBuilder.toString());
        System.out.println("----");

    }
}
