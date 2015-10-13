package a_lambda;

import java.util.concurrent.CompletableFuture;

class FunctionalInterfaces {
    public static void main(String[] args) {
        //Interfaces like Runnable or Comparable are also just "code blocks" that we want to move around.
        Runnable someCode = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };

        //The code above should now be executed in a different thread
        CompletableFuture.runAsync(someCode);

        //This is the same as
        CompletableFuture.runAsync(() -> System.out.println("Hello world"));

        //That means that kind of interfaces are compatible to lambdas in Java.
        Runnable someOtherCode = () -> System.out.println("Hello world");
        CompletableFuture.runAsync(someOtherCode);

        //One might now think that the compiler creates an object of that interface when compiling the code.
        //This is almost true. In fact the object is created as one would expect, but at runtime not at compile time.

        //Interfaces which are compatible to lambdas are called "Functional Interfaces."

    }

}
