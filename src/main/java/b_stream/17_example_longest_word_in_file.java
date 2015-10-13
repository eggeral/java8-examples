package b_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class LongestWordInFile {

    public static void main(String[] args) throws IOException {
        Pattern wordSeparator = Pattern.compile("[\\P{L}]+");

        try(Stream<String> lines = Files.lines(Paths.get("frankenstein.txt"))) {
            System.out.println(lines.flatMap(l -> wordSeparator.splitAsStream(l))
                    .max((lhs, rhs) -> Integer.compare(lhs.length(), rhs.length())).get());
        }

    }
}
