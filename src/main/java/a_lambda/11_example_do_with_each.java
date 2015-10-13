package a_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class DoWithEach {

    public static void main(String[] args) {
        List<String> flights = Arrays.asList("OS201", "OS202", "LH4532", "4U234");
        doWithEach(flights, System.out::println);

        System.out.println("---");
        doWithEach(flights, flight -> System.out.println(flight.substring(0,2)));
    }

    private static void doWithEach(List<String> flights, Consumer<String> consumer) {
        for (String flight : flights) {
            consumer.accept(flight);
        }
    }
}
