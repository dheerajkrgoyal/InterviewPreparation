package com.interview.designguru.lld.parklinglot.manager;

import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.findstrategy.FirstEmpty;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager{

    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList){
        super(new FirstEmpty(), parkingSpotList);
    }
}
