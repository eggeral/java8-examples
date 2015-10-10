package b_stream;

import java.util.Arrays;
import java.util.stream.Stream;

class DebugStreamsWithPeek {
    public static void main(String[] args) {
        String[] flights = Stream.of("OS201", "OS204", "LH4567")
                .peek(x -> System.out.println("Fetching: " + x))
                .limit(2).toArray(String[]::new);
        System.out.println(Arrays.toString(flights));
    }
}
