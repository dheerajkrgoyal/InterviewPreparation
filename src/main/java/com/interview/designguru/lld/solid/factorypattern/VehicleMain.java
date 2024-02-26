package com.interview.designguru.lld.solid.factorypattern;

public class VehicleMain {

    public static void main(String[] args) {
        Vehicle bmw = VehicleFactory.getVehicle("BMW");
        bmw.drive();

        VehicleFactoryInterface vehicleFactory = AbstractVehicleFactory.getVehicleFactory("ORDINARY");
        Vehicle hyundai = vehicleFactory.getVehicle("HYUNDAI");
        hyundai.drive();

    }
}
