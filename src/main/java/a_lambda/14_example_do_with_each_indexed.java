package a_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

class DoWithEachIndexed {

    public static void main(String[] args) {
        List<String> flights = Arrays.asList("OS201", "OS202", "LH4532", "4U234", "LH3456");
        doWithEachIndexed(flights, (index, flight) -> System.out.println(index + ": " + flight));

        System.out.println("---");
        doWithEachIndexed(flights, (index, flight) -> {
            System.out.print(flight);
            if ((index + 1) % 2 == 0)
                System.out.println();
            else
                System.out.print(", ");
        });
    }

    private static void doWithEachIndexed(List<String> flights, BiConsumer<Integer, String> consumer) {
        for (int index = 0; index < flights.size(); index++) {
            consumer.accept(index, flights.get(index));
        }
    }
}
