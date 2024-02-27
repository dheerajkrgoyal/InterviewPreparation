package com.interview.designguru.lld.parklinglot.fairstrategy;

import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.Ticket;
import com.interview.designguru.lld.parklinglot.entity.Vehicle;

public class MinuteFareStrategy implements FareStrategy{

    @Override
    public long calculateFair(Vehicle vehicle) {
        Ticket ticket  = vehicle.ticket;
        ParkingSpot parkingSpot = ticket.parkingSpot;
        long currentTime = System.currentTimeMillis();
        long minuteTaken =1+ ((currentTime - ticket.entryTime)/(1000 * 60));
        return minuteTaken * parkingSpot.price;
    }
}
