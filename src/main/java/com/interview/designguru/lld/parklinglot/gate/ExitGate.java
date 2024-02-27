package com.interview.designguru.lld.parklinglot.gate;

import com.interview.designguru.lld.parklinglot.entity.Vehicle;
import com.interview.designguru.lld.parklinglot.factory.FareCalculatorFactory;
import com.interview.designguru.lld.parklinglot.fairstrategy.FareCalculator;

public class ExitGate {

    public static long vehicleExit(Vehicle vehicle){
        FareCalculator fareCalculator = FareCalculatorFactory.getInstance().getFairCalculator(vehicle);
        long fare  = fareCalculator.calculateFare(vehicle);
        System.out.println("Fare calculated: Rs. " + fare);
        return fare;
    }
}
