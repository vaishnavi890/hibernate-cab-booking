package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.BookingHistory;
import com.vaishnavi.hibernate.cab.booking.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookingHistories")
public class BookingHistoryController {

    @Autowired
    private BookingHistoryService service;

    @PostMapping
    public ResponseEntity<BookingHistory> createBookingHistory(@RequestBody BookingHistory bookingHistory) {
        return new ResponseEntity<>(service.createBookingHistory(bookingHistory), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingHistory> deleteBookingHistory(@PathVariable("id") int bookingHistoryId) {
        return new ResponseEntity<>(service.deleteBookingHistory(bookingHistoryId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingHistory> getBookingHistory(@PathVariable("id") int bookingHistoryId) {
        return new ResponseEntity<>(service.getBookingHistoryById(bookingHistoryId), HttpStatus.OK);
    }

    @GetMapping
    public List<BookingHistory> getAllBookingHistories() {
        return service.getAllBookingHistories();
    }
}


