package playground;

import java.util.function.Consumer;

public class RunTwoThreadsWithExceptionHandler {

    public static void runBoth(Runnable r1, Runnable r2, Consumer<Exception> handler) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           try {
               r1.run();
           }
           catch (Exception ex)
           {
               handler.accept(ex);
           }
        });

        Thread t2 = new Thread(() -> {
            try {
                r2.run();
            }
            catch (Exception ex)
            {
                handler.accept(ex);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        runBoth(() -> System.out.println("r1"),
                () -> {throw new NullPointerException("TEST");},
        e -> System.out.println(e.getMessage()));

    }
}
