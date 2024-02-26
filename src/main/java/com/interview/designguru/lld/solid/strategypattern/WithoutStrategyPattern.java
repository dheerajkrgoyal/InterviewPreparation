package com.interview.designguru.lld.solid.strategypattern;
/**
 * OffRoadVehicle and SportVehicle are overriding drive from parent but both have same implementation.
 * Can't we re-use the code somehow rather than duplicating same implementation?
 * That's where strategy pattern comes in.
 */
abstract class Vehicle{
    public void drive(){
        System.out.println("normal drive");
    }
}

class PassengerVehicle extends Vehicle {

}

class OffRoadVehicle extends Vehicle{
    @Override
    public void drive(){
        System.out.println("special drive");
    }
}

class SportVehicle extends Vehicle{
    @Override
    public void drive(){
        System.out.println("special drive");
    }
}
public class WithoutStrategyPattern {
}
