package com.interview.designguru.lld.parklinglot.fairstrategy;

public class TwoWheelerFareCalculator extends FareCalculator{

    public TwoWheelerFareCalculator(){
        super(new MinuteFareStrategy());
    }
}
