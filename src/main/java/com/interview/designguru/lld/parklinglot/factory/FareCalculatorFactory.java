package com.interview.designguru.lld.parklinglot.factory;

import com.interview.designguru.lld.parklinglot.entity.Vehicle;
import com.interview.designguru.lld.parklinglot.fairstrategy.FareCalculator;
import com.interview.designguru.lld.parklinglot.fairstrategy.FourWheelerFareCalculator;
import com.interview.designguru.lld.parklinglot.fairstrategy.TwoWheelerFareCalculator;

public class FareCalculatorFactory {
    private static FareCalculatorFactory instance;
    private TwoWheelerFareCalculator twoWheelerFareCalculator;
    private FourWheelerFareCalculator fourWheelerFareCalculator;

    private FareCalculatorFactory(){

    }

    public static synchronized FareCalculatorFactory getInstance(){
        if(null == instance){
            instance = new FareCalculatorFactory();
            instance.fourWheelerFareCalculator = new FourWheelerFareCalculator();
            instance.twoWheelerFareCalculator = new TwoWheelerFareCalculator();
        }
        return instance;
    }

    public FareCalculator getFairCalculator(Vehicle vehicle){
        return switch (vehicle.vehicleType){
            case TWO_WHEELER -> instance.twoWheelerFareCalculator;
            case FOUR_WHEELER -> instance.fourWheelerFareCalculator;
            default -> null;
        };
    }
}
