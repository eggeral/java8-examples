package b_stream;

import java.util.Arrays;
import java.util.stream.Stream;

class StreamCreation {
    public static void main(String[] args) {
        // Stream from a List
        Arrays.asList("a", "b", "c").stream().forEach(System.out::print);
        System.out.println();
        // Stream.of
        Stream.<String> of("a", "b", "c").forEach(System.out::print);
        System.out.println();
        Stream.of(new String[] { "a", "b", "c" }).forEach(System.out::print);
        System.out.println();
        // Stream from Array
        Arrays.stream(new String[] { "a", "b", "c" }, 1, 2).forEach(System.out::print);
        System.out.println();
        // Empty stream
        Stream.empty().forEach(System.out::print);
        System.out.println();
        // Stream.generate and Stream.iterate generate endless streams! Use limit before
        // applying a terminal operation!
        Stream.generate(() -> "a").limit(3).forEach(System.out::print);
        System.out.println();
        Stream.iterate(1, x -> x * 2).limit(5).forEach(System.out::print);
        System.out.println();
        // Stream.builder
        Stream.builder().add("a").add("b").add("c").build().forEach(System.out::print);
        System.out.println();

        Stream.Builder<String> builder = Stream.builder();
        builder.accept("a");
        builder.accept("b");
        builder.accept("c");
        builder.build().forEach(System.out::print);
        System.out.println();

    }
}
