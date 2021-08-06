package com.gridnine.testing.filter;

import java.util.List;
import java.util.stream.Collectors;

import com.gridnine.testing.models.Flight;

public class ArrivalBeforeDeparture {

    public List<Flight> findFlights(List<Flight> flights) {
        return flights.stream()
                .filter(this::containsSegmentWhereArrivalsBeforeDepartures)
                .collect(Collectors.toList());
    }

    private boolean containsSegmentWhereArrivalsBeforeDepartures(Flight flight) {
        return flight.getSegments().stream()
                .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }
}
