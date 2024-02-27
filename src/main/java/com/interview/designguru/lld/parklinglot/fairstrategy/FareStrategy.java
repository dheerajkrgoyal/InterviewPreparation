package com.interview.designguru.lld.parklinglot.fairstrategy;

import com.interview.designguru.lld.parklinglot.entity.Vehicle;

public interface FareStrategy {
    public long calculateFair(Vehicle vehicle);
}
