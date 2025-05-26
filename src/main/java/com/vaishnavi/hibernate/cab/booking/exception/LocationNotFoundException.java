package com.vaishnavi.hibernate.cab.booking.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String msg) {
        super(msg);
    }
}

