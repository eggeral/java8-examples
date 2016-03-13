package b_stream;

import java.util.stream.Stream;

class LimitSkipCombine {
    public static void main(String[] args) {
        // try the following line without limit :-)
        Stream.iterate(1, x -> x + 1).limit(5).forEach(System.out::print);
        System.out.println();
        Stream.iterate(1, x -> x + 1).skip(3).limit(5).forEach(System.out::print);
        System.out.println();

        Stream.concat(
                Stream.iterate(1, x -> x + 1).limit(5), // first stream has to be limited
                Stream.iterate(10, x -> x + 2)) //second stream can be infinite
                .limit(10).forEach(System.out::print);
        System.out.println();
    }
}
