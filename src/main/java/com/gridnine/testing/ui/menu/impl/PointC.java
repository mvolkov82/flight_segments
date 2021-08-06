package com.gridnine.testing.ui.menu.impl;

import java.util.List;

import com.gridnine.testing.filter.GroundTimeOverLimit;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;
import com.gridnine.testing.ui.menu.MenuItem;

public class PointC extends MenuItem {
    public PointC(String label, String description) {
        super(label, description);
    }

    @Override
    public void run() {
        List<Flight> allFlights = FlightBuilder.createFlights();
        GroundTimeOverLimit groundTimeOverLimit = new GroundTimeOverLimit();
        List<Flight> overGroundTimeLimitFlights = groundTimeOverLimit.findFlights(allFlights, 2);
        System.out.println(overGroundTimeLimitFlights);
    }
}
