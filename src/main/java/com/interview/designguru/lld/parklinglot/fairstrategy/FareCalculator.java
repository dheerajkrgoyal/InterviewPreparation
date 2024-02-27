package com.interview.designguru.lld.parklinglot.fairstrategy;

import com.interview.designguru.lld.parklinglot.entity.Vehicle;

public class FareCalculator {
    public FareStrategy fareStrategy;

    public FareCalculator(FareStrategy fareStrategy){
        this.fareStrategy = fareStrategy;
    }

    public long calculateFare(Vehicle vehicle){
        return fareStrategy.calculateFair(vehicle);
    }
}
