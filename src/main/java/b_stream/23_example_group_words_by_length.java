package b_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GroupWordsByLength {

    public static void main(String[] args) throws IOException {
        // count the number of words of each length

        Stream<String> lines = Files.lines(Paths.get("frankenstein.txt"));
        System.out.println(lines.flatMap(l -> Arrays.stream(l.split("[\\P{L}]+")))
                .collect(Collectors.groupingBy(w -> w.length(), Collectors.counting())));
    }
}
