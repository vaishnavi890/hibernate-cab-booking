package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.Ride;
import com.vaishnavi.hibernate.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService service;

    @PostMapping
    public ResponseEntity<Ride> createRide(@RequestBody Ride ride) {
        return new ResponseEntity<>(service.createRide(ride), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ride> deleteRide(@PathVariable("id") int rideId) {
        return new ResponseEntity<>(service.deleteRide(rideId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRide(@PathVariable("id") int rideId) {
        return new ResponseEntity<>(service.getRideById(rideId), HttpStatus.OK);
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return service.getAllRides();
    }
}


