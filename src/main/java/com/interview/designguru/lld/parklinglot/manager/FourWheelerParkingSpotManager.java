package com.interview.designguru.lld.parklinglot.manager;

import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.findstrategy.NearestToEntry;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{

    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpotList){
        super(new NearestToEntry(), parkingSpotList);
    }
}
