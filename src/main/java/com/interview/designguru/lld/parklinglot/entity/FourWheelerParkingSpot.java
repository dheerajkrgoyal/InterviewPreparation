package com.interview.designguru.lld.parklinglot.entity;

import com.interview.designguru.lld.parklinglot.constants.ParkingSpotType;

public class FourWheelerParkingSpot extends ParkingSpot{
    public ParkingSpotType type;
    public FourWheelerParkingSpot(int id){
        this.id = id;
        this.price = 20;
        this.type = ParkingSpotType.FOUR_WHEELER;
    }
}
