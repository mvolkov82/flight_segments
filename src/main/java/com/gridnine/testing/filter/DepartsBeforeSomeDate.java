package com.gridnine.testing.filter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.gridnine.testing.models.Flight;

public class DepartsBeforeSomeDate {

    public List<Flight> findFlights(List<Flight> flights, LocalDateTime dateTime) {
        return flights.stream()
                .filter(flight -> containsSegmentWhereDepartureBeforeDate(flight, dateTime))
                .collect(Collectors.toList());
    }

    private boolean containsSegmentWhereDepartureBeforeDate(Flight flight, LocalDateTime dateTime) {
        return flight.getSegments().stream().anyMatch(segment -> segment.getDepartureDate().isBefore(dateTime));
    }
}
