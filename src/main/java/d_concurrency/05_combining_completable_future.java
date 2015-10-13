package d_concurrency;

import java.util.concurrent.*;

class CombiningCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> 10l).thenAccept(System.out::println).get();
        System.out.println("---");

        // ..Async methods run the subsequent method in a new thread pool.
        CompletableFuture.supplyAsync(() -> 10l).thenAcceptAsync(System.out::println).get();
        System.out.println("---");

        CompletableFuture.supplyAsync(() -> 10l).thenApply(x -> x * 2).thenAccept(System.out::println).get();
        System.out.println("---");

        CompletableFuture.supplyAsync(() -> 10l).thenRun(() -> System.out.println("TEST")).get();
        System.out.println("---");

        CompletableFuture.supplyAsync(() -> 10l)
                .thenCompose(x -> CompletableFuture.supplyAsync(() -> x * 3))
                .thenAccept(System.out::println).get();
        System.out.println("---");

        CompletableFuture.supplyAsync(() -> 10l)
                .thenCompose(x -> CompletableFuture.supplyAsync(() -> x * 3))
                .thenAccept(System.out::println).get();
        System.out.println("---");

        CompletableFuture.supplyAsync(() -> 10l)
                .thenCombine(CompletableFuture.supplyAsync(() -> 15l), (r1, r2) -> r1 + r2)
                .thenAccept(System.out::println).get();
        System.out.println("---");

        CompletableFuture.supplyAsync(() -> 10l).thenApply(x -> {
            throw new NullPointerException(("BANG"));
        }).handle((r, e) -> {
            if (e != null)
                return e.getMessage();
            return r.toString();
        }).thenAccept(System.out::println).get();
        System.out.println("---");

        CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> 10l),
                CompletableFuture.supplyAsync(() -> 20l)
                ).thenRun(() -> System.out.println("Hallo")).get();
        System.out.println("---");

        CompletableFuture.supplyAsync(() -> 10l)
                .applyToEither(CompletableFuture.supplyAsync(() -> 20l),
                        x -> x * 5)
                .thenAccept(System.out::println).get();
        System.out.println("---");

    }
}
