package com.gridnine.testing.ui.menu.impl;

import java.util.List;

import com.gridnine.testing.filter.ArrivalBeforeDeparture;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;
import com.gridnine.testing.ui.menu.MenuItem;

public class PointB extends MenuItem {

    public PointB(String label, String description) {
        super(label, description);
    }

    @Override
    public void run() {
        List<Flight> allFlights = FlightBuilder.createFlights();
        ArrivalBeforeDeparture arrivalBeforeDeparture = new ArrivalBeforeDeparture();
        List<Flight> arrivalsBeforeDeparture = arrivalBeforeDeparture.findFlights(allFlights);
        System.out.println(arrivalsBeforeDeparture);
    }
}
