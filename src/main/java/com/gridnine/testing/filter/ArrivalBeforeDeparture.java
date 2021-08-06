package com.gridnine.testing.filter;

import java.util.ArrayList;
import java.util.List;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

public class ArrivalBeforeDeparture {

    public List<Flight> findFlights(List<Flight> flights) {
        List<Flight> arrivalsBeforeDepartures = new ArrayList<>();

        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    arrivalsBeforeDepartures.add(flight);
                    break;
                }
            }
        }
        return arrivalsBeforeDepartures;
    }
}
