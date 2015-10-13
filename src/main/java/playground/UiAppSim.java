package playground;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class UiAppSim {
    public static void main(String[] args) {
        File file = new File("test.out");
        CompletableFuture.runAsync(() -> writeIntoFile(file)).handle((v, e) -> {
            if (e != null)
                System.out.println(e.getMessage());
            return null;
        });
        System.out.println("main thread done");
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

    private static void writeIntoFile(File file) {
        System.out.println("Starting file write");
        for (int i = 0; i < 10; i++) {
            System.out.println("Progress = " + i * 10 + " %");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done file write");
        throw new IllegalStateException("File write failed");

    }
}
