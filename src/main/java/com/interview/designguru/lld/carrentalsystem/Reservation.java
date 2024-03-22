package com.interview.designguru.lld.carrentalsystem;

import com.interview.designguru.lld.carrentalsystem.product.Vehicle;

public class Reservation {
    int id;
    User user;
    Vehicle vehicle;
    BookingDetail bookingDetail;
    ReservationStatus reservationStatus;
}
