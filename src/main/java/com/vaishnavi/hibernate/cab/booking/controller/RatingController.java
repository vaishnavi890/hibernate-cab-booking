package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.Rating;
import com.vaishnavi.hibernate.cab.booking.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(service.createRating(rating), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rating> deleteRating(@PathVariable("id") int ratingId) {
        return new ResponseEntity<>(service.deleteRating(ratingId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable("id") int ratingId) {
        return new ResponseEntity<>(service.getRatingById(ratingId), HttpStatus.OK);
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return service.getAllRatings();
    }
}


