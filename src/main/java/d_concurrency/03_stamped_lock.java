package d_concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

class StampedLockClass {
    static long counterA;
    static long counterB;

    public static void main(String[] args) {
        // Lets have a look at a situation where we have many readers and just a
        // view writers.
        //Sync locks readers even if it would be safe to have multiple readers!
        Object mutex = new Object();
        measure(() -> {
            synchronized (mutex) {
                counterA++;
                counterB++;
            }
        } , () -> {
            synchronized (mutex) {
                // Multiple reader would be ok!
                if (counterA != counterB)
                    System.out.println("WARNING!!!!");
            }
        });

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        measure(() -> {
            readWriteLock.writeLock().lock();
            counterA++;
            counterB++;
            readWriteLock.writeLock().unlock();
        } , () -> {
            readWriteLock.readLock().lock();
            // Multiple readers go here at the same time!!!
            // Still the performance ist bad -> they are almost useless.
            if (counterA != counterB)
                System.out.println("WARNING!!!!");
            readWriteLock.readLock().unlock();
        });

        // Stamped locks solve that problem
        // As long as we have many more readers as writers (see measure method)
        StampedLock stampedLock = new StampedLock();
        measure(() -> {
            long stamp = stampedLock.writeLock();
            counterA++;
            counterB++;
            stampedLock.unlockWrite(stamp);
        } , () -> {
            long stamp = stampedLock.tryOptimisticRead();
            // we try with an unexpensive optimistic read lock!
            long a = counterA;
            long b = counterB;
            if (!stampedLock.validate(stamp)) { // did the values change?
                stamp = stampedLock.readLock(); // Yes. We need a real lock!
                try {
                    a = counterA;
                    b = counterB;
                } finally {
                    stampedLock.unlockRead(stamp);
                }
            }
            if (a != b)
                System.out.println("WARNING!!!!");
        });

    }

    private static void measure(Runnable writer, Runnable reader) {
        Instant now = Instant.now();
        List<Thread> threads = new ArrayList<>();
        counterA = 0;
        counterB = 0;
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1_000; j++) {
                    writer.run();
                }
            });
            threads.add(thread);
            thread.start();

            thread = new Thread(() -> {
                for (int j = 0; j < 1_000_000; j++) {
                    reader.run();
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
        System.out.println(counterA);
        System.out.println("----");
    }
}
