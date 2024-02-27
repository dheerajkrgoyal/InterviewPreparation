package com.interview.designguru.lld.parklinglot.entity;

public class Ticket {
    public long entryTime;
    public ParkingSpot parkingSpot;

    public Ticket(long entryTime, ParkingSpot parkingSpot){
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }
}
