package com.interview.designguru.lld.carrentalsystem;

import com.interview.designguru.lld.carrentalsystem.product.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int id;
    List<Vehicle> vehicleInventory;
    Location location;
    List<Reservation> reservations;

    public Store(int id, Location location){
        this.id = id;
        this.vehicleInventory = new ArrayList<>();
        this.location = location;
        this.reservations = new ArrayList<>();
    }
}
