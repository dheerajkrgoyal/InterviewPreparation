package com.interview.designguru.lld.solid.factorypattern;

public class VehicleFactory {

    public static Vehicle getVehicle(String type){
        return switch (type) {
            case "BMW" -> new BMW();
            case "MERCEDES" -> new Mercedes();
            case "SUZUKI" -> new Suzuki();
            case "HYUNDAI" -> new Hyundai();
            default -> null;
        };
    }
}
