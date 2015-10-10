package a_lambda;

class PropertiesOfFunctionalInterfaces {

    //Functional interfaces must have only one abstract method.
    interface MyIntFunction {
        int apply(int x);
    }

    public static void applyMyIntFunction() {
        MyIntFunction times5 = x -> x * 5;
        System.out.println("Result of 2 times5: " + times5.apply(2));
    }

    //Non abstract methods in interfaces do not count!
    interface MyDoubleFunction {
        double apply(double x);
        String toString(); // Defined in Object therefore not abstract!
    }

    public static void applyMyDoubleFunction() {
        MyDoubleFunction times3 = x -> x * 3;
        System.out.println("Result of 3 times5: " + times3.apply(3));
    }

    //Optional! Mark an Functional Interface with @FunctionalInterface
    @FunctionalInterface
    interface MyLongFunction {
        long apply(long x);
    }

    //A lambda can be used everywhere where a FunctionalInterface is expected.

    public static void main(String[] args) {
        applyMyIntFunction();
        applyMyDoubleFunction();
    }
}
