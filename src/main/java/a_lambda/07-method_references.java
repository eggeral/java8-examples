package a_lambda;

import java.util.function.*;

class MethodReferences {

    public static void main(String[] args) {
        // The following lambda
        Consumer<Object> print = x -> System.out.println(x);

        // Can be rewritten as "method reference"
        print = System.out::println;

        // There are three cases:
        // object::instanceMethod
        // (see above ^)

        // Class:staticMethod
        BiFunction<Double, Double, Double> pow = (x,y) -> Math.pow(x,y);
        pow = Math::pow;

        // Class::instanceMethod
        BiFunction<String, String, String> concat = (x, y) -> x.concat(y);
        concat = String::concat;

        print.accept(pow.apply(3.0,2.0));
        print.accept(concat.apply("Hello ", "World"));
    }

}
