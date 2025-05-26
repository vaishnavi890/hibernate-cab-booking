package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.RideRequest;

import java.util.List;
import java.util.Optional;

public interface RideRequestRepository {
    RideRequest save(RideRequest rideRequest);
    List<RideRequest> findAll();
    Optional<RideRequest> findById(int id);
    RideRequest deleteById(int id);
}

