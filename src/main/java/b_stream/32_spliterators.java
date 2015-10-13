package b_stream;

import java.util.*;
import java.util.stream.Collector;

class Spliterators {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("a", "b", "c", "d", "e", "f");
        // Spliterators have certain characteristics. Algorithms working on them
        // can react on this characteristics.
        /*
         * ORDERED DISTINCT SORTED SIZED NONNULL IMMUTABLE CONCURRENT SUBSIZED
         */

        System.out.println((strs.spliterator().characteristics() & Spliterator.SIZED) == Spliterator.SIZED);
        System.out.println("---");

        Spliterator spliterator = strs.spliterator();
        System.out.println(spliterator.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(spliterator.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(spliterator.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(spliterator.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(spliterator.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(spliterator.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(spliterator.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println("---");

        spliterator = strs.spliterator();
        Spliterator s1 = spliterator.trySplit();
        System.out.println(s1.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(s1.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(s1.tryAdvance(x -> System.out.print(x + " -> ")));
        System.out.println(s1.tryAdvance(x -> System.out.print(x + " -> ")));

        System.out.println(spliterator.trySplit().getExactSizeIfKnown());
        System.out.println(spliterator.trySplit().getExactSizeIfKnown());
        System.out.println(spliterator.trySplit());
        System.out.println("---");

        spliterator = strs.spliterator();
        spliterator.tryAdvance(x -> System.out.println(x));
        spliterator.forEachRemaining(x -> System.out.println(x));
        System.out.println("---");

        System.out.println(spliterator.getComparator());

    }
}
