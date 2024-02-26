package com.interview.designguru.lld.solid.factorypattern;

public class AbstractVehicleFactory {
    public static VehicleFactoryInterface getVehicleFactory(String type){
        return switch (type){
            case "LUXURY" -> new LuxuryVehicleFactory();
            case "ORDINARY" -> new OrdinaryVehicleFactory();
            default -> null;
        };
    }
}
