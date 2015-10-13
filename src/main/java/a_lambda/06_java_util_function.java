package a_lambda;

import java.util.function.*;
import java.util.function.Predicate;

class JavaUtilFunction {

    public static void main(String[] args) {
        //Some useful functional interfaces are implemented in java.util.function

        Function<Integer, Integer> func = x -> x * x;
        IntFunction intFunc = x -> x * 3;
        BiFunction<Double, Integer, String> bifunc = (x, y) -> "result: " + ( x * y );
        Supplier<String> supplier = () -> "TEST";
        Consumer<String> consumer = x -> System.out.println(x);
        Predicate<String> predicate = x -> x.equals("playground");

    }
}
