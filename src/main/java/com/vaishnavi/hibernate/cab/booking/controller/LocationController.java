package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.Location;
import com.vaishnavi.hibernate.cab.booking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService service;

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        return new ResponseEntity<>(service.createLocation(location), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable("id") int locationId) {
        return new ResponseEntity<>(service.deleteLocation(locationId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable("id") int locationId) {
        return new ResponseEntity<>(service.getLocationById(locationId), HttpStatus.OK);
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return service.getAllLocations();
    }
}


