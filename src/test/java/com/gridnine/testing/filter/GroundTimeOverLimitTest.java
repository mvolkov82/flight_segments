package com.gridnine.testing.filter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gridnine.testing.filter.repository.TestRepository;
import com.gridnine.testing.models.Flight;
import org.junit.jupiter.api.Test;

class GroundTimeOverLimitTest {
    private final List<Flight> allFlights = TestRepository.getTestFlights();

    @Test
    void shouldReturnListOfFlightsWhereTotalGroundTimeMoreThan2Hours() {
        GroundTimeOverLimit groundTimeOverLimit = new GroundTimeOverLimit();
        List<Flight> actual = groundTimeOverLimit.findFlights(allFlights, 2);
        List<Flight> expected = getExpectedFlights();
        assertEquals(actual, expected);
    }

    private List<Flight> getExpectedFlights() {
        List<Flight> expectedFlights = new ArrayList<>();
        expectedFlights.add(allFlights.get(4));
        expectedFlights.add(allFlights.get(5));
        return expectedFlights;
    }
}