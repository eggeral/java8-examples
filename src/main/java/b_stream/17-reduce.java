package b_stream;

import java.util.Optional;
import java.util.stream.Stream;

class Reduce {
    static class Flight {
        int passengers;
        Flight(int passengers) {
            this.passengers = passengers;
        }
    }

    public static void main(String[] args) {
        // Simplest form of reduce:
        // Apply a binary function on each element and the last
        // result.
        Optional<Integer> sum = Stream.of(1, 2, 3, 4).reduce((current, next) -> current + next);
        System.out.println(sum);
        System.out.println("--");

        // As long as the reduce operation is associative the operation is parallelizable.
        // (sum is subtraction is not!). We will have a look at parallel streams later.

        // Sum with a start value (identity value)
        int intSum = Stream.of(1, 2, 3, 4).reduce(11, (current, next) -> current + next);
        System.out.println(intSum);
        System.out.println("--");

        // The identity value is returned if the stream is empty (Therefore Optional is not necessary).
        intSum = Stream.<Integer>empty().reduce(12, (current, next) -> current + next);
        System.out.println(intSum);
        System.out.println("--");

        // Using a value other than 0 as identity value for sum is indeed wrong and breaks the sum
        // if we use parallel streams!!!

        // Sum of all passengers.
        int passengers = Stream.of(new Flight(41), new Flight(61)).reduce(
                0, // identity
                (current, next) -> current + next.passengers, // how to add an element to an existing result
                (lhs, rhs) -> lhs + rhs // how to combine two results.
                );
        System.out.println(passengers);
        System.out.println("--");


    }
}
