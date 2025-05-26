package com.vaishnavi.hibernate.cab.booking.exception;

public class RideNotFoundException extends RuntimeException {
    public RideNotFoundException(String msg) {
        super(msg);
    }
}


