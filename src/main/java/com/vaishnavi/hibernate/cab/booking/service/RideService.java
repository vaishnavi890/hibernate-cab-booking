package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.RideNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Ride;
import com.vaishnavi.hibernate.cab.booking.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public Ride deleteRide(int id) {
        return rideRepository.deleteById(id);
    }

    public Ride retrieveRide(int id) {
        Optional<Ride> ride = rideRepository.findById(id);
        if (ride.isEmpty()) {
            throw new RideNotFoundException("Ride not found");
        }
        return ride.get();
    }

    public List<Ride> retrieveRides() {
        return rideRepository.findAll();
    }

    public Ride getRideById(int rideId) {
        return null;
    }

    public List<Ride> getAllRides() {
        return List.of();
    }
}


