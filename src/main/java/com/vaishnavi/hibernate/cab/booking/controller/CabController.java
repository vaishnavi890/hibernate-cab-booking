package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.Cab;
import com.vaishnavi.hibernate.cab.booking.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabs")
public class CabController {

    @Autowired
    private CabService service;

    @PostMapping
    public ResponseEntity<Cab> createCab(@RequestBody Cab cab) {
        return new ResponseEntity<>(service.createCab(cab), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cab> deleteCab(@PathVariable("id") int cabId) {
        return new ResponseEntity<>(service.deleteCab(cabId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cab> getCab(@PathVariable("id") int cabId) {
        return new ResponseEntity<>(service.getCabById(cabId), HttpStatus.OK);
    }

    @GetMapping
    public List<Cab> getAllCabs() {
        return service.getAllCabs();
    }
}


