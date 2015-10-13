package playground;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class UiAppSim {
    static class ProgressBar {
        private double max;

        ProgressBar(double max) {
            this.max = max;
        }
        public void progress(int progress) {
            System.out.print((100 / max) * progress);
            System.out.println(" %");
        }

    }

    public static void main(String[] args) {

        File file = new File("test.out");
        ProgressBar progressBar = new ProgressBar(50);
        CompletableFuture.runAsync(() -> writeIntoFile(file, progressBar)).handle((v, e) -> {
            if (e != null)
                System.out.println(e.getMessage());
            return null;
        });
        System.out.println("main thread done");
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

    private static void writeIntoFile(File file, ProgressBar progressBar) {
        System.out.println("Starting file write");
        for (int i = 1; i <= 50; i++) {
            progressBar.progress(i);
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