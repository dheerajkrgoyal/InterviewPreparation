package com.interview.designguru.lld.parklinglot;

import com.interview.designguru.lld.parklinglot.constants.VehicleType;
import com.interview.designguru.lld.parklinglot.entity.Vehicle;
import com.interview.designguru.lld.parklinglot.gate.EntryGate;
import com.interview.designguru.lld.parklinglot.gate.ExitGate;

public class ParkingLotApp {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("WB02AH2453", VehicleType.FOUR_WHEELER);
        EntryGate.vehicleEntry(vehicle);

        ExitGate.vehicleExit(vehicle);

        Vehicle vehicle1 = new Vehicle("WB74P7654", VehicleType.TWO_WHEELER);
        EntryGate.vehicleEntry(vehicle1);
        ExitGate.vehicleExit(vehicle1);
    }
}
