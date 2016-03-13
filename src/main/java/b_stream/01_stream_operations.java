package b_stream;

import java.util.stream.Stream;

class StreamOperations {
    public static void main(String[] args) {
        // Generating streams
        Stream<Integer> stream = Stream.of(10, 20, 30, 50);

        // Intermediate operations
        // Each operation returns a reference to the stream again
        // Evaluated lazily
        stream = stream.filter(x -> x > 10).filter(x -> x < 50);

        // Terminal operations start the evaluation of
        // the intermediate operations. After the evaluation
        // of the terminal operation the stream is finished
        // and can not be used for further operations.
        System.out.println(stream.count());

        // Stream pipelines consist of a source followed be 0 ore more intermediate
        // operations and a terminal operation

        // Stream consumed. The following statement fails!
        stream.count();

    }
}
