package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingRepository {
    Rating save(Rating rating);
    List<Rating> findAll();
    Optional<Rating> findById(int id);
    Rating deleteById(int id);
}

