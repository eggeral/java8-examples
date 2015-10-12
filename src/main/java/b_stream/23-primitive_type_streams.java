package b_stream;

import java.security.SecureRandom;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class PrimitiveTypeStreams {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(System.out::print);
        System.out.println("\n---");

        IntStream intStream = Stream.of("a", "aa", "aaa").mapToInt(s -> s.length());
        intStream.forEach(System.out::print);
        System.out.println("\n---");

        Random random = new SecureRandom();
        OptionalInt max = random.ints().limit(10).max();
        System.out.println(max.getAsInt());
        System.out.println("---");

        //This does not work because the Collectors do not work on primitive types
        //random.ints().limit(10).collect(Collectors.mapping(x -> x.toString(),Collectors.joining(",")));

        //boxed helps
        String rnd = random.ints().limit(10).boxed().collect(Collectors.mapping(x -> x.toString(),Collectors.joining(",")));
        System.out.println(rnd);
    }
}
