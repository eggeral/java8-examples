package b_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class GroupWordsByLengthAndExample {

    static class Summary {
        int count;
        List<String> examples = new ArrayList<>();

        public String toString() {
            return count + ": " + String.join(", ", examples);
        }
    }


    public static void main(String[] args) throws IOException {

        Stream<String> lines = Files.lines(Paths.get("frankenstein.txt"));

        Map<Integer,?> result = lines
                .flatMap(l -> Arrays.stream(l.split("[\\P{L}]+")))
                .collect(groupingBy(w -> w.length(), summarizing()));

        result.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static  Collector<String, Summary, Summary> summarizing() {
        return new Collector<String, Summary, Summary>() {
            @Override
            public Supplier<Summary> supplier() {
                return Summary::new;
            }

            @Override
            public BiConsumer<Summary, String> accumulator() {
                return (summary, element) -> {
                    summary.count ++;
                    if (summary.count <= 4)
                        summary.examples.add(element);
                };
            }

            @Override
            public BinaryOperator<Summary> combiner() {
                return (lhs, rhs) -> {
                    lhs.count  = lhs.count + rhs.count;
                    while (lhs.examples.size() <= 4 && rhs.examples.size() > 0) {
                        lhs.examples.add(rhs.examples.get(0));
                        rhs.examples.remove(0);
                    }
                    return lhs;
                };
            }

            @Override
            public Function<Summary, Summary> finisher() {
                return Function.identity();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return EnumSet.of(Collector.Characteristics.CONCURRENT,
                        Collector.Characteristics.UNORDERED);
            }
        };
    }

}
