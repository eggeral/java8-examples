package a_lambda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

class DataExporterLambda {
    // We want to do something with a prefix and a suffix put with something unknown in between.
    public static void main(String[] args) throws IOException {
        class Flight {
            String id;
            String from;
            String to;

            Flight(String id, String from, String to) {
                this.id = id;
                this.from = from;
                this.to = to;
            }
        }

        List<Flight> flights = Arrays.asList(new Flight("OS201", "GRZ", "DUS"), new Flight("OS202", "DUS", "GRZ"));


        writeToDatFile("flights2.dat", writer -> {
            writer.write("Flight,From,To\n");
            for (Flight flight : flights) {
                writer.write(flight.id + "," + flight.from + "," + flight.to + "\n");
            }
        });

        int x = 10;
        writeToDatFile("calculations2.dat", writer -> {
            writer.write("x*2=" + (x * 2) + "\n");
            writer.write("x/2=" + (x / 2) + "\n");
        });

    }

    interface WriterConsumer {
        void accept(Writer writer) throws IOException;
    }

    private static void writeToDatFile(String filename, WriterConsumer consumer) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write("This is a dat file\n");
            consumer.accept(fileWriter);
            fileWriter.write("End of transmission\n");
        }
    }
}
