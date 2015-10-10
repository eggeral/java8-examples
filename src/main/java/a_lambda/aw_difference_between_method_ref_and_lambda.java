package a_lambda;

import java.util.Arrays;
import java.util.List;

class DifferenceBetweenMethodRefAndLambda {

    public static void main(String[] args) {
        // Run with -Djdk.internal.lambda.dumpProxyClasses=... in order to output the created Functional Interface
        // classes.

        List<String> aList = Arrays.asList("eins", "zwei", "drei");
        // Simply get the object into the Functional Interface and call the method. So there is not much difference
        // between lambda and method ref. Of course there is no need for the compiler to create a lambda method.
        // Also the method is not called by invokespecial but by invokevirtual.

        aList.forEach(System.out::println);
        /*
         * final class DifferenceBetweenMethodRefAndLambda$$Lambda$1 implements Consumer {
         *   private final PrintStream arg$1;
         *   private DifferenceBetweenMethodRefAndLambda$$Lambda$1(PrintStream var1) {
         *     this.arg$1 = var1;
         *   }
         * 
         *   private static Consumer get$Lambda(PrintStream var0) {
         *     return new DifferenceBetweenMethodRefAndLambda$$Lambda$1(var0);
         *   }
         * 
         *   @Hidden public void accept(Object var1) {
         *     this.arg$1.println((String)var1);
         *   }
         * }
         */

        aList.forEach((value) -> System.out.println("- " + value));
        // In this case the lambda becomes a static method which makes calling it from the Functional Interface object
        // easier.

        /*
         * final class DifferenceBetweenMethodRefAndLambda$$Lambda$2 implements Consumer {
         *   private DifferenceBetweenMethodRefAndLambda$$Lambda$2() { }
         * 
         *   @Hidden public void accept(Object var1) {
         *     DifferenceBetweenMethodRefAndLambda.lambda$main$1((String)var1);
         *   }
         * }
         */
    }
}
