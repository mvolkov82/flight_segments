package com.gridnine.testing.filter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.gridnine.testing.models.Flight;

public class GroundTimeOverLimit {
    public static final int MINUTES_IN_HOUR = 60;

    public List<Flight> findFlights(List<Flight> flights, int groundTimeHoursLimit) {
        List<Flight> flightsOverGroundTimeLimit = new ArrayList<>();

        for (Flight flight : flights) {
            int groundTimeInMinutes = 0;

            if (flight.getSegments().size() > 1) {
                for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                    LocalDateTime currentSegmentArrival = flight.getSegments().get(i).getArrivalDate();
                    LocalDateTime nextSegmentDeparture = flight.getSegments().get(i + 1).getDepartureDate();
                    //Consider only segments where chronological chain is correct
                    if (currentSegmentArrival.isBefore(nextSegmentDeparture)) {
                        groundTimeInMinutes += Duration.between(currentSegmentArrival, nextSegmentDeparture).toMinutes();
                    }
                }

                if (groundTimeInMinutes > groundTimeHoursLimit * MINUTES_IN_HOUR) {
                    flightsOverGroundTimeLimit.add(flight);
                }
            }
        }
        return flightsOverGroundTimeLimit;
    }
}
