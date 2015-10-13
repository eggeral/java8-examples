package a_lambda;

class DefaultMethods {
    // Lambdas are very useful and it makes sense to extend existing interfaces and add methods which
    // take lambdas.
    // For example Collection should have a forEach method taking a lambda.
    // But adding that to Collection breaks _every_ implementation of Collection that exists. A breaking change
    // Java could not make. That's why "default methods" where invented.

    interface Flight {
        String getId();

        String getFrom();

        String getTo();

        default String getCsv() {
            return getId() + "," + getFrom() + "," + getTo();
        }
    }

    static class AuaFlight implements Flight {

        private final String id;
        private final String from;
        private final String to;

        AuaFlight(String id, String from, String to) {
            this.id = id;
            this.from = from;
            this.to = to;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }
    }

    public static void main(String[] args) {
        Flight auaFlight = new AuaFlight("OS204", "GRZ", "DUS");
        System.out.println(auaFlight.getCsv());

    }
}
