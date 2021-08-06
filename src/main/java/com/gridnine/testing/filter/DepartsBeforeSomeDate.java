package com.gridnine.testing.filter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

public class DepartsBeforeSomeDate {

    public List<Flight> findFlights(List<Flight> flights, LocalDateTime dateTime) {
        List<Flight> previousFlights = new ArrayList<>();

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            for (Segment segment : segments) {
                if (segment.getDepartureDate().isBefore(dateTime)) {
                    previousFlights.add(flight);
                    break;
                }
            }
        }
        return previousFlights;
    }
}
