package b_stream;

import java.util.Random;
import java.util.stream.Stream;

class RandomNumbers {
    public static void main(String[] args) {
        // Find the first 10 numbers lower than 5 in a stream of random int between 0 and 9.
        Random rnd = new Random();
        Stream<Integer> numbers = Stream.generate(() -> rnd.nextInt(10));
        numbers.filter( n -> n < 5).limit(10).forEach(System.out::println);
    }
}
