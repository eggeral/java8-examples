package b_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class StreamFromPatternAndFile {
    public static void main(String[] args) throws IOException {
        // Streams from patterns.
        Pattern.compile("[,;]").splitAsStream("a,b;c").forEach(System.out::print);
        System.out.println();

        //Streams from files
        Path test = Paths.get("test.txt");
        Files.write(test, "a\nb\nc\n".getBytes(), StandardOpenOption.CREATE);

        // Streams implement AutoClosable. When a stream is closed the underlying file
        // is also closed.
        try(Stream lines = Files.lines(test)) {
            lines.forEach(System.out::print);
        }
        Files.delete(test);
    }
}
