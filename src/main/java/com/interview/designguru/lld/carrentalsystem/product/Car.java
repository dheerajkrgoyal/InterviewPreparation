package com.interview.designguru.lld.carrentalsystem.product;

public class Car extends Vehicle{

    public Car(int id, String vehicleNo){
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.vechicleType = VechicleType.CAR;
        this.vehicleStatus = VechileStatus.ACTIVE;
    }
}
