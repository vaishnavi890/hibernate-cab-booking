package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.RatingNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Rating;
import com.vaishnavi.hibernate.cab.booking.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating deleteRating(int id) {
        return ratingRepository.deleteById(id);
    }

    public Rating retrieveRating(int id) {
        Optional<Rating> rating = ratingRepository.findById(id);
        if (rating.isEmpty()) {
            throw new RatingNotFoundException("Rating not found");
        }
        return rating.get();
    }

    public List<Rating> retrieveRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(int ratingId) {
        return null;
    }

    public List<Rating> getAllRatings() {
        return List.of();
    }
}


