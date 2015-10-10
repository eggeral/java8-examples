package b_stream;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Ordering {
    public static void main(String[] args) {

        //parallel processing messes up the order of the the output
        List<Integer> aLotOfIntegers = Stream.iterate(0, (x -> x + 1)).limit(100000).collect(Collectors.toList());

        aLotOfIntegers.stream().map(Ordering::expensiveMap).limit(10).forEach(x -> System.out.print(x + ", "));
        System.out.println("\n---");
        aLotOfIntegers.stream().parallel().map(Ordering::expensiveMap).limit(10).forEach(x -> System.out.print(x + ", "));
        System.out.println("\n---");


        // methods like distinct and limit are expensive if the operate on ordered streams in parallel
        Random rnd = new Random();
        List<Integer> aLotOfRandomInts = rnd.ints(1_000_000).boxed().collect(Collectors.toList());

        System.out.println("Sequential distinct");
        measure(() -> aLotOfRandomInts.stream().distinct().mapToInt(x -> x.intValue()).sum());
        System.out.println("Parallel distinct");
        measure(() -> aLotOfRandomInts.stream().parallel().distinct().mapToInt(x -> x.intValue()).sum());
        System.out.println("Parallel unordered distinct");
        measure(() -> aLotOfRandomInts.stream().parallel().unordered().distinct().mapToInt(x -> x.intValue()).sum());

        // Concurrent collecting can speed up collecting but the order of the collected items is not guarantied.
        measure(() -> aLotOfRandomInts.stream().parallel().collect(Collectors.groupingBy(x -> x % 100_000)));
        measure(() -> aLotOfRandomInts.stream().parallel().collect(Collectors.groupingByConcurrent(x -> x % 100_000)));

    }

    private static void measure(Runnable operation) {
        Instant start = Instant.now();
        for (int i = 0; i < 100; i++) {
            operation.run();
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.println("\n" + duration);
        System.out.println("---");
    }

    private static int expensiveMap(int current) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return current * 2;
    }

}
