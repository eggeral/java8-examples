package d_concurrency;

import java.util.concurrent.*;

class CompletableFutures {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Until Java 8 there was no easy way of saying to a Future. When done then do X
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<Long> worker1 = executor.submit(() -> doWork("w1", 2));
        Future<Long> worker2 = executor.submit(() -> doWork("w2", 3));

        System.out.println("sum = " + (worker1.get() + worker2.get()));
        executor.shutdown();
        System.out.println("---");

        CompletableFuture future = CompletableFuture.supplyAsync(() -> doWork("w1", 99));
        // normally there is no need to wait for a completable future!
        future.get();
        System.out.println("---");

        future = CompletableFuture.supplyAsync(
                () -> doWork("w1", 12))
                .thenAcceptBoth(CompletableFuture.supplyAsync(
                                () -> doWork("w2", 23)),
                        (result1, result2) -> System.out.println("sum = " + (result1 + result2)));
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

    private static Long doWork(String worker, long result) {
        System.out.println(worker + " start");
        sleep(1000);
        System.out.println(worker + " end");
        return result;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
