package com.interview.designguru.lld.solid.factorypattern;

public class OrdinaryVehicleFactory implements VehicleFactoryInterface{
    @Override
    public Vehicle getVehicle(String type) {
        return switch (type){
            case "SUZUKI" -> new Suzuki();
            case "HYUNDAI" -> new Hyundai();
            default -> null;
        };
    }
}
