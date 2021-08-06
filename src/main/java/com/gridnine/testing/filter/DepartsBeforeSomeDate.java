package com.gridnine.testing.filter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.gridnine.testing.models.Flight;

public class DepartsBeforeSomeDate {

    public List<Flight> findFlights(List<Flight> flights, LocalDateTime dateTime) {
        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight flight : flights) {
            if (containsSegmentWhereDepartureBeforeDate(flight, dateTime)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    private boolean containsSegmentWhereDepartureBeforeDate(Flight flight, LocalDateTime dateTime){
        return flight.getSegments().stream().anyMatch(segment -> segment.getDepartureDate().isBefore(dateTime));
    }
}

