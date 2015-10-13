package d_concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLocks {
    static volatile long counter;

    public static void main(String[] args) {
        // ReadWriteLocks are better than synchronized because they allow
        // more than one reader if there is no writer.
        // But they are slow!
        Object mutex = new Object();
        measure(() -> {
            synchronized (mutex) {
                counter++;
            }
        });

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        measure(() -> {
            readWriteLock.writeLock().lock();
            counter++;
            readWriteLock.writeLock().unlock();
        });

    }

    private static void measure(Runnable runnable) {
        Instant now = Instant.now();
        List<Thread> threads = new ArrayList<>();
        counter = 0;
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1_000_000; j++) {
                    runnable.run();
                }
            });
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(Duration.between(now, Instant.now()));
        System.out.println(counter);
        System.out.println("----");
    }
}
