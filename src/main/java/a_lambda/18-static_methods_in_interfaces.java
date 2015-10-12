package a_lambda;

import java.util.*;

class StaticMethodsInInterfaces {
    // now we get rid of Collection/Collections and Path/Paths
    interface Flight {
        String getId();

        static boolean areUnique(List<Flight> flights) {
            HashSet<String> knownIds = new HashSet<>();
            for (Flight flight : flights) {
                if (knownIds.contains(flight.getId()))
                    return false;
                knownIds.add(flight.getId());
            }
            return true;
        }
    }

    static class AuaFlight implements Flight {
        private String id;

        AuaFlight(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new AuaFlight("OS201"));
        flights.add(new AuaFlight("OS202"));
        System.out.println(Flight.areUnique(flights));
        flights.add(new AuaFlight("OS202"));
        System.out.println(Flight.areUnique(flights));
    }
}
