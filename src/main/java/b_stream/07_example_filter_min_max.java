package b_stream;

import java.util.stream.Stream;

class FilterMinMax {
    static class MeasurementPoint {
        private final long timestamp;
        private final double value;

        MeasurementPoint(long timestamp, double value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        //Get the timestamps of all values between a given min max.
        Stream<MeasurementPoint> measurements = Stream.of(
                new MeasurementPoint(1001, 50),
                new MeasurementPoint(1002, 20),
                new MeasurementPoint(1003, 11),
                new MeasurementPoint(1004, 61),
                new MeasurementPoint(1005, 32));

        measurements.filter(m -> m.value > 15 && m.value < 55).map(m -> m.timestamp).forEach(System.out::println);
    }
}
