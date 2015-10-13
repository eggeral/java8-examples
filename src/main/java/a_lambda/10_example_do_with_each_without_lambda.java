package a_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class DoWithEachWithoutLambda {

    public static void main(String[] args) {
        List<String> flights = Arrays.asList("OS201", "OS202", "LH4532", "4U234");
        printAllFlights(flights);

        System.out.println("---");
        printAllCarriers(flights);
    }

    private static void printAllFlights(List<String> flights) {
        for (String flight : flights) {
            System.out.println(flight);
        }
    }

    private static void printAllCarriers(List<String> flights) {
        for (String flight : flights) {
            System.out.println(flight.substring(0,2));
        }
    }
}
