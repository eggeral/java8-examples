package a_lambda;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class DataExporter {
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

        try (FileWriter fileWriter = new FileWriter("flights.dat")) {
            fileWriter.write("This is a dat file\n");
            fileWriter.write("Flight,From,To\n");
            for (Flight flight : flights) {
                fileWriter.write(flight.id + "," + flight.from + "," + flight.to + "\n");
            }
            fileWriter.write("End of transmission\n");
        }

        int x = 10;
        try (FileWriter fileWriter = new FileWriter("calculations.dat")) {
            fileWriter.write("This is a dat file\n");
            fileWriter.write("x*2=" + (x * 2) + "\n");
            fileWriter.write("x/2=" + (x / 2) + "\n");
            fileWriter.write("End of transmission\n");
        }
   }

}
