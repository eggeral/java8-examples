package b_stream;

import java.util.stream.Stream;

class Fibonacci {
    public static void main(String[] args) {
        Stream.iterate(new long[] { 1, 1 }, p -> new long[] { p[1], p[0] + p[1] }).limit(92).forEach(p -> System.out.println(p[0]));
    }
}
