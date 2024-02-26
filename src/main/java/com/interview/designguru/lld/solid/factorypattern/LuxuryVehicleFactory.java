package com.interview.designguru.lld.solid.factorypattern;

public class LuxuryVehicleFactory implements VehicleFactoryInterface{
    @Override
    public Vehicle getVehicle(String type) {
        return switch (type) {
            case "BMW" -> new BMW();
            case "MERCEDES" -> new Mercedes();
            default -> null;
        };
    }
}
