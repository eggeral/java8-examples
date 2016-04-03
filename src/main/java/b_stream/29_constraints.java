package b_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Constrains {
    public static void main(String[] args) {
        // Non-interference
        // As long as only lazy operations are are executed on streams the underlying data structure can be
        // altered. But not afterwards!
        List<String> flights = new ArrayList<>(Arrays.asList("OS201", "OS202", "LH4567"));
        Stream<String> flightsStream = flights.stream();
        flights.add("U4556");
        System.out.println(flightsStream.collect(Collectors.joining(", ")));
        System.out.println("---");

        // The list must not be changed while processing the stream
//        flightsStream.forEach(s -> {
//            if (s.startsWith("OS"))
//                flights.remove(s);
//        });

        // Stateful operations have undetermined output if streams are processed in parallel.
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6);

        // Do this 5 times to show different results caused by parallel processing.
        for (int i = 0; i < 5; i++) {
            Set<Integer> seen = Collections.synchronizedSet(new HashSet<>());
            // if the value was already processed before we add 0 otherwise the element
            number.stream().parallel().map(e -> {
                if (seen.add(e))
                    return 0;
                else
                    return e;
            }).forEachOrdered(s -> System.out.print(s + ", "));
            System.out.println();
        }

        System.out.println("---");
        List<Integer> ints = IntStream.range(0, 10_000).boxed().collect(Collectors.toList());

        // Side-effects are dangerous and have to be avoided
        for (int i = 0; i < 5; i++) {
            int[] sum = new int[1];
            ints.stream().parallel().forEach(x -> sum[0] = sum[0] + x);
            // Unnecessary use of side-effects!            
            System.out.println(sum[0]);
        }
        System.out.println("---");
        for (int i = 0; i < 5; i++) {
            System.out.println(ints.stream().parallel().mapToInt(x -> x.intValue()).sum());
        }
    }
}
