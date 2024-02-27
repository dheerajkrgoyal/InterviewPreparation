package com.interview.designguru.lld.parklinglot.findstrategy;

import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface FindStrategy {
    public Optional<ParkingSpot> findParkingSpot(Vehicle vehicle, List<ParkingSpot> listOfParkingSpot);
}
