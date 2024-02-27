package com.interview.designguru.lld.parklinglot.gate;

import com.interview.designguru.lld.parklinglot.entity.Vehicle;
import com.interview.designguru.lld.parklinglot.factory.FareCalculatorFactory;
import com.interview.designguru.lld.parklinglot.factory.ParkingSpotManagerFactory;
import com.interview.designguru.lld.parklinglot.fairstrategy.FareCalculator;
import com.interview.designguru.lld.parklinglot.manager.ParkingSpotManager;

public class ExitGate {

    public static long vehicleExit(Vehicle vehicle){
        FareCalculator fareCalculator = FareCalculatorFactory.getInstance().getFairCalculator(vehicle);
        ParkingSpotManager parkingSpotManager = ParkingSpotManagerFactory.getInstance().getParkingSpotManager(vehicle);
        long fare  = fareCalculator.calculateFare(vehicle);
        System.out.println("Fare calculated: Rs. " + fare);
        parkingSpotManager.freeParkingSpot(vehicle);
        System.out.println("Parking spot is free now.");
        return fare;
    }
}
