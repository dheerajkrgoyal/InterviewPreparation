package com.interview.designguru.lld.parklinglot.fairstrategy;

import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.Ticket;
import com.interview.designguru.lld.parklinglot.entity.Vehicle;

public class HourFareStrategy implements FareStrategy{
    @Override
    public long calculateFair(Vehicle vehicle) {
        Ticket ticket  = vehicle.ticket;
        ParkingSpot parkingSpot = ticket.parkingSpot;
        long currentTime = System.currentTimeMillis();
        long hourTaken =1+ ((currentTime - ticket.entryTime)/(1000 * 60*60));
        return hourTaken * parkingSpot.price;
    }
}
