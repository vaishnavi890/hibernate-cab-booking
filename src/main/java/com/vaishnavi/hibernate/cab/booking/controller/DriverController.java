package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.Driver;
import com.vaishnavi.hibernate.cab.booking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        return new ResponseEntity<>(service.createDriver(driver), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Driver> deleteDriver(@PathVariable("id") int driverId) {
        return new ResponseEntity<>(service.deleteDriver(driverId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable("id") int driverId) {
        return new ResponseEntity<>(service.getDriverById(driverId), HttpStatus.OK);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }
}


