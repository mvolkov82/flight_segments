package com.gridnine.testing.filter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gridnine.testing.filter.repository.TestRepository;
import com.gridnine.testing.models.Flight;
import org.junit.jupiter.api.Test;

class TestArrivalBeforeDepartureTest {
    private final List<Flight> allFlights = TestRepository.getTestFlights();

    @Test
    void shouldReturnListOfFlightsWherePresentSegmentsWithArrivalsBeforeDeparture() {
        ArrivalBeforeDeparture arrivalBeforeDeparture = new ArrivalBeforeDeparture();
        List<Flight> actual = arrivalBeforeDeparture.findFlights(allFlights);
        List<Flight> expected = getExpectedFlights();
        assertEquals(actual, expected);
    }

    private List<Flight> getExpectedFlights(){
        List<Flight> expectedFlights = new ArrayList<>();
        expectedFlights.add(allFlights.get(3));
        return expectedFlights;
    }
}
