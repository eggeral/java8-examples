package a_lambda;

import java.util.function.Supplier;

class Closures {

    private static double PI = 3.1415;

    public static void main(String[] args) {
        String world = "World";

        Supplier<String> helloWorld = () -> "Hello " + world;
        Supplier<Double> piTimes2 = () -> PI * 2;

        // Lambdas can capture variables from their surrounding scope.
        // This is called closure.
        // Inner classes always did that by the way.
        print(helloWorld);
        print(piTimes2);

        // In Java captured variables must not change!
        int counter = 0;
        Supplier<Integer> intSupplier = () -> counter + 5;
        // counter ++; // this is not allowed!
        // This is called "effectively final"
        // Prior the Java 8 inner classes could only capture final variables.
        // In Java 8 the compiler tries to figure that out for you.
        intSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return counter + 5; // In Java 7 counter has to be declared final.
            }
        };

        // The effectively final rule only applies to local variables
        PI = PI * 2; // This is valid

        // If your lambda really needs to update the counter:
        int[] boxedCounter = new int[1];
        intSupplier = () -> boxedCounter[0] + 5;

        boxedCounter[0] ++;

        System.out.println("Boxed integer counter: ");
        print(intSupplier);

    }

    private static <T> void print(Supplier<T> supplier) {
        System.out.println(supplier.get());
    }
}
