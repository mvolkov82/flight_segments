package com.gridnine.testing.filter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gridnine.testing.filter.repository.TestRepository;
import com.gridnine.testing.models.Flight;
import org.junit.jupiter.api.Test;

class DepartsBeforeSomeDateTest {
    List<Flight> allFlights = TestRepository.getTestFlights();

    @Test
    void shouldReturnListOfFlightsWherePresentSegmentWithDepartsBeforeNow() {
        DepartsBeforeSomeDate departsBeforeSomeDate = new DepartsBeforeSomeDate();
        List<Flight> actual = departsBeforeSomeDate.findFlights(allFlights, LocalDateTime.now());
        List<Flight> expected = getExpectedFlights();
        assertEquals(actual, expected);
    }

    private List<Flight> getExpectedFlights() {
        List<Flight> expectedFlights = new ArrayList<>();
        expectedFlights.add(allFlights.get(2));
        return expectedFlights;
    }
}
