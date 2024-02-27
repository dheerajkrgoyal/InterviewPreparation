package com.interview.designguru.lld.parklinglot.gate;

import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.Ticket;
import com.interview.designguru.lld.parklinglot.entity.Vehicle;
import com.interview.designguru.lld.parklinglot.factory.ParkingSpotManagerFactory;
import com.interview.designguru.lld.parklinglot.manager.ParkingSpotManager;

import java.util.Optional;

public class EntryGate {
    ParkingSpotManager parkingSpotManager;

    public static Vehicle vehicleEntry(Vehicle vehicle){
        ParkingSpotManagerFactory managerFactory = ParkingSpotManagerFactory.getInstance();
        ParkingSpotManager manager = managerFactory.getParkingSpotManager(vehicle);
        Optional<ParkingSpot> parkingSpot = manager.findParkingSpot(vehicle);
        parkingSpot.ifPresent(spot -> vehicle.ticket = new Ticket(System.currentTimeMillis(), spot));
        return vehicle;
    }
}
