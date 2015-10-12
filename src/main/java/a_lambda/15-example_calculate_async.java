package a_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CalculateAsync {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> passengers = Arrays.asList(50, 60, 55);

        runAsync(() -> {
            int sum = 0;
            for (Integer num : passengers) {
                sum = sum + num;
            }
            return sum;
        } , System.out::println);
        Thread.sleep(1000);
    }

    private static <T> void runAsync(Supplier<T> supplier, Consumer<T> consumer) {
        Thread thread = new Thread(() -> {
            T result = supplier.get();
            consumer.accept(result);
        });

        thread.start();
    }

}
