package com.interview.designguru.lld.solid.strategypattern;


interface DriveStrategy{
    void drive();
}

class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("normal drive");
    }
}

class SpecialDriveStrategy implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("special drive");
    }
}

class VehicleStrategy{
    DriveStrategy driveStrategy;

    public VehicleStrategy(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        this.driveStrategy.drive();
    }
}

class PassengerVehicleStrategy extends VehicleStrategy{
    public PassengerVehicleStrategy(){
        super(new NormalDriveStrategy());
    }
}

class SportVehicleStrategy extends VehicleStrategy{
    public SportVehicleStrategy(DriveStrategy driveStrategy){
        super(new SpecialDriveStrategy());
    }
}

class OffRoadVehicleStrategy extends VehicleStrategy{
    public OffRoadVehicleStrategy(DriveStrategy driveStrategy){
        super(driveStrategy);
    }
}

public class WithStrategyPattern {
}
