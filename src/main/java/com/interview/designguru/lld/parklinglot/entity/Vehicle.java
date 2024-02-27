package com.interview.designguru.lld.parklinglot.entity;

import com.interview.designguru.lld.parklinglot.constants.VehicleType;

public class Vehicle {
    public String vehicleNo;
    public VehicleType vehicleType;
    public Ticket ticket;

    public Vehicle(String vehicleNo, VehicleType vehicleType){
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }
}
