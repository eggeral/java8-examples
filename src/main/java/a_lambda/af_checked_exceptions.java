package a_lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

class CheckedExceptions {

    public static void main(String[] args) {
        // If the lambda throws an checked exception the abstract method of
        // the corresponding functional interface has to declare that exception
        // Therefore the following does not compile:

        // Runnable run = () -> Files.createFile(Paths.get("test.txt"));

        // Solution 1: Catch the exception inside of the lambda
        Runnable run = () -> {
            try {
                Files.createFile(Paths.get("test.txt"));
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        };

        // Solution 2: Use a functional interface which declares the exception
        // V call() throws Exception;
        Callable<Void> call = () -> {
            Files.createFile(Paths.get("test.txt"));
            return null;
        };

    }
}
