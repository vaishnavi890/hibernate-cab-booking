package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.RideRequest;
import com.vaishnavi.hibernate.cab.booking.service.RideRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rideRequests")
public class RideRequestController {

    @Autowired
    private RideRequestService service;

    @PostMapping
    public ResponseEntity<RideRequest> createRideRequest(@RequestBody RideRequest rideRequest) {
        return new ResponseEntity<>(service.createRideRequest(rideRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RideRequest> deleteRideRequest(@PathVariable("id") int requestId) {
        return new ResponseEntity<>(service.deleteRideRequest(requestId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideRequest> getRideRequest(@PathVariable("id") int requestId) {
        return new ResponseEntity<>(service.getRideRequestById(requestId), HttpStatus.OK);
    }

    @GetMapping
    public List<RideRequest> getAllRideRequests() {
        return service.getAllRideRequests();
    }
}


