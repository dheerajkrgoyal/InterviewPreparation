package com.interview.designguru.lld.parklinglot.manager;

import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.Vehicle;
import com.interview.designguru.lld.parklinglot.findstrategy.FindStrategy;

import java.util.List;
import java.util.Optional;

public class ParkingSpotManager {
    List<ParkingSpot> listOfParkingSpot;
    FindStrategy findStrategy;

    public ParkingSpotManager(FindStrategy findStrategy, List<ParkingSpot> listOfParkingSpot){
        this.findStrategy = findStrategy;
        this.listOfParkingSpot = listOfParkingSpot;
    }

    public Optional<ParkingSpot> findParkingSpot(Vehicle vehicle){
        return findStrategy.findParkingSpot(vehicle, listOfParkingSpot);
    }

    public boolean occupyParkingSpot(Vehicle vehicle){
        vehicle.ticket.parkingSpot.isEmpty = false;
        return true;
    }
    public boolean freeParkingSpot(Vehicle vehicle){
        vehicle.ticket.parkingSpot.isEmpty = true;
        return true;
    }
}
