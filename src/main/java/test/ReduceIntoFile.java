package test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReduceIntoFile {
    static class Person {
        public final String name;
        public final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {

        // This is not recommended! Und does not work with .parallel
        Stream<Person> persons = Stream.of(new Person("Max", 41),
                new Person("Franz", 22), new Person("Helmut", 55));

        try (Writer writer = Files.newBufferedWriter(Paths.get("test.csv"))) {
            persons.reduce("name,age", (current, next) -> {
                try {
                    writer.write(current + "\n" + next.name + "," + next.age);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "";
            } , (lhs, rhs) -> lhs + rhs);

        }

    }
}
