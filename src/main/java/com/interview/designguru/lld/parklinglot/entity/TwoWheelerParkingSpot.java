package com.interview.designguru.lld.parklinglot.entity;

import com.interview.designguru.lld.parklinglot.constants.ParkingSpotType;

public class TwoWheelerParkingSpot extends ParkingSpot{
    public ParkingSpotType type;

    public TwoWheelerParkingSpot(int id){
        this.id = id;
        this.price = 10;
        this.type = ParkingSpotType.TWO_WHEELER;
    }
}
