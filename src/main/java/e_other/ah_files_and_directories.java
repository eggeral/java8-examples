package e_other;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class FilesAndDirectories {
    public static void main(String[] args) throws IOException {
        try(Stream<String> lines = Files.lines(Paths.get("frankenstein.txt"))) {
            lines.forEach(System.out::println);
            lines.onClose(() -> System.out.println("File closing!"));
        }
        System.out.println("=============================");

        try(Stream<String> lines = new BufferedReader(new FileReader("frankenstein.txt")).lines()) {
            lines.forEach(System.out::println);
            lines.onClose(() -> System.out.println("File closing - new!"));
        }
        System.out.println("=============================");

        try(Stream<Path> entries = Files.list(Paths.get("."))) {
            entries.forEach(System.out::println);
        }

        System.out.println("=============================");
        try(Stream<Path> entries = Files.walk(Paths.get("."))) {
            entries.forEach(System.out::println);
        }

    }
}
