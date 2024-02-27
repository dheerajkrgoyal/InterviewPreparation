package com.interview.designguru.lld.parklinglot.factory;

import com.interview.designguru.lld.parklinglot.entity.FourWheelerParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.ParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.TwoWheelerParkingSpot;
import com.interview.designguru.lld.parklinglot.entity.Vehicle;
import com.interview.designguru.lld.parklinglot.manager.FourWheelerParkingSpotManager;
import com.interview.designguru.lld.parklinglot.manager.ParkingSpotManager;
import com.interview.designguru.lld.parklinglot.manager.TwoWheelerParkingSpotManager;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManagerFactory {

    private static ParkingSpotManagerFactory instance = null ;
    private TwoWheelerParkingSpotManager twoWheelerParkingSpotManager;
    private FourWheelerParkingSpotManager fourWheelerParkingSpotManager;

    private ParkingSpotManagerFactory(){
    }

    public static synchronized ParkingSpotManagerFactory getInstance(){
        if(null == instance){
            List<ParkingSpot> twoWheelerParkingSpot = new ArrayList<>();
            for(int i = 0; i<20; i++){
                twoWheelerParkingSpot.add(new TwoWheelerParkingSpot(i));
            }
            List<ParkingSpot> fourWheelerParkingSpot = new ArrayList<>();
            for(int i = 20; i<30; i++){
                fourWheelerParkingSpot.add(new FourWheelerParkingSpot(i));
            }
            instance = new ParkingSpotManagerFactory();
            instance.twoWheelerParkingSpotManager = new TwoWheelerParkingSpotManager(twoWheelerParkingSpot);
            instance.fourWheelerParkingSpotManager = new FourWheelerParkingSpotManager(fourWheelerParkingSpot);
        }
        return instance;
    }

    public ParkingSpotManager getParkingSpotManager(Vehicle vehicle){
        return switch (vehicle.vehicleType){
            case TWO_WHEELER -> instance.twoWheelerParkingSpotManager;
            case FOUR_WHEELER -> instance.fourWheelerParkingSpotManager;
            default -> null;
        };
    }
}
