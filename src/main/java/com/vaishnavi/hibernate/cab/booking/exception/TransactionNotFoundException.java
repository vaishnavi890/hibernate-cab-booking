package com.vaishnavi.hibernate.cab.booking.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String msg) {
        super(msg);
    }
}


