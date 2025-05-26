package com.vaishnavi.hibernate.cab.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<Object> handleDriverNotFound(DriverNotFoundException ex) {
        return new ResponseEntity<>("Driver not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RideNotFoundException.class)
    public ResponseEntity<Object> handleRideNotFound(RideNotFoundException ex) {
        return new ResponseEntity<>("Ride not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<Object> handlePaymentNotFound(PaymentNotFoundException ex) {
        return new ResponseEntity<>("Payment not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<Object> handleRatingNotFound(RatingNotFoundException ex) {
        return new ResponseEntity<>("Rating not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CabNotFoundException.class)
    public ResponseEntity<Object> handleCabNotFound(CabNotFoundException ex) {
        return new ResponseEntity<>("Cab not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<Object> handleLocationNotFound(LocationNotFoundException ex) {
        return new ResponseEntity<>("Location not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RideRequestNotFoundException.class)
    public ResponseEntity<Object> handleRideRequestNotFound(RideRequestNotFoundException ex) {
        return new ResponseEntity<>("Ride request not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<Object> handleNotificationNotFound(NotificationNotFoundException ex) {
        return new ResponseEntity<>("Notification not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingHistoryNotFoundException.class)
    public ResponseEntity<Object> handleBookingHistoryNotFound(BookingHistoryNotFoundException ex) {
        return new ResponseEntity<>("Booking history not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<Object> handleTransactionNotFound(TransactionNotFoundException ex) {
        return new ResponseEntity<>("Transaction not found.", HttpStatus.NOT_FOUND);
    }
}


