package a_lambda;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

class Flight {
    String flightNumber;

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "[Flight] flightNumber: " + flightNumber;
    }
}

class ConstructorReferences {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // basically the same as method refs
        // which constructor is called depends on the context.
        List<String> strings = createDummies(2, String::new);
        System.out.println(strings);

        List<Flight> flights = createDummies(5, Flight::new);
        System.out.println(flights);

        // This replaces to old Java pattern for creating something of a generic type:
        flights = createDummiesOldStyle(3, Flight.class);
        System.out.println(flights);

        // Also works with Arrays
        String[] stringArray = toArray(strings, x -> new String[x]);
        System.out.println(Arrays.toString(stringArray));

        stringArray = toArray(strings, String[]::new);
        System.out.println(Arrays.toString(stringArray));

        Flight[] flightArray = toArray(flights, Flight[]::new);
        System.out.println(Arrays.toString(flightArray));


    }

    private static <T> T[] toArray(List<T> list, IntFunction<T[]> generator) {
        T[] result = generator.apply(list.size());
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static <T> List<T> createDummies(int number, Function<String, T> generator) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            result.add(generator.apply("dummy" + i));
        }
        return result;
    }

    private static <T> List<T> createDummiesOldStyle(int number, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            result.add(clazz.getConstructor(String.class).newInstance("dummy" + i));
        }
        return result;
    }


}
