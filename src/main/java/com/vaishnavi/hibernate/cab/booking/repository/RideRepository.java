package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.Ride;

import java.util.List;
import java.util.Optional;

public interface RideRepository {
    Ride save(Ride ride);
    List<Ride> findAll();
    Optional<Ride> findById(int id);
    Ride deleteById(int id);
}


