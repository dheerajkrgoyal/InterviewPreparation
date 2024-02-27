package com.interview.designguru.lld.parklinglot.fairstrategy;

public class FourWheelerFareCalculator extends FareCalculator{

    public FourWheelerFareCalculator(){
        super(new HourFareStrategy());
    }
}
