package a_lambda;

class DefaultMethodResolution {
    // If there are multiple implementations of a default method which one wins?
    interface Flight {
        default String getId() {
            return "dummy";
        }
    }

    interface InternationalFlight {
        default String getId() {
            return "international dummy";
        }
    }

    interface GermanFlight extends Flight {
        default String getId() {
            return "german dummy";
        }
    }

    static class GermanWingsFlight implements GermanFlight {
    }

    static class AuaFlight implements Flight {
        @Override
        public String getId() {
            return "aua dummy";
        }
    }

    public static void main(String[] args) {
        // If a class implements the default method the method of the class wins.
        Flight auaFlight = new AuaFlight();
        System.out.println(auaFlight.getId());

        // The more specific interface wins.
        Flight germanWingsFlight = new GermanWingsFlight();
        System.out.println(germanWingsFlight.getId());

        // Other conflicts have to be solved by the user
        class LufthansaFlight implements Flight, InternationalFlight {
            // Error: class LufthansaFlight inherits unrelated defaults for getId() from types
            // lambda.DefaultMethodResolution.Flight and lambda.DefaultMethodResolution.InternationalFlight

            @Override
            public String getId() {
                return Flight.super.getId() + ":" + InternationalFlight.super.getId();
            }

        }

    }

}
