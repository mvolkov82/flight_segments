package com.gridnine.testing.ui.menu.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.gridnine.testing.filter.DepartsBeforeSomeDate;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;
import com.gridnine.testing.ui.menu.MenuItem;

public class PointA extends MenuItem {
    private DepartsBeforeSomeDate departsBeforeSomeDate = new DepartsBeforeSomeDate();

    public PointA(String label, String description) {
        super(label, description);
    }

    @Override
    public void run() {
        List<Flight> allFlights = FlightBuilder.createFlights();
        List<Flight> flightsBeforeNow = departsBeforeSomeDate.findFlights(allFlights, LocalDateTime.now());
        System.out.println(flightsBeforeNow);
    }
}
