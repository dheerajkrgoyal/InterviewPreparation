package com.interview.designguru.lld.parklinglot.entity;

import com.interview.designguru.lld.parklinglot.constants.ParkingSpotType;

public abstract class ParkingSpot {
    public int id;
    public int price;

    public boolean isEmpty=true;

    public ParkingSpotType type;
}
