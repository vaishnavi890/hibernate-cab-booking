package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.RideRequestNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.RideRequest;
import com.vaishnavi.hibernate.cab.booking.repository.RideRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RideRequestService {

    @Autowired
    private RideRequestRepository rideRequestRepository;

    public RideRequest createRequest(RideRequest request) {
        return rideRequestRepository.save(request);
    }

    public RideRequest deleteRequest(int id) {
        return rideRequestRepository.deleteById(id);
    }

    public RideRequest retrieveRequest(int id) {
        Optional<RideRequest> request = rideRequestRepository.findById(id);
        if (request.isEmpty()) {
            throw new RideRequestNotFoundException("Ride request not found");
        }
        return request.get();
    }

    public List<RideRequest> retrieveRequests() {
        return rideRequestRepository.findAll();
    }

    public RideRequest deleteRideRequest(int requestId) {
        return null;
    }

    public RideRequest createRideRequest(RideRequest rideRequest) {
        return rideRequest;
    }

    public RideRequest getRideRequestById(int requestId) {
        return null;
    }

    public List<RideRequest> getAllRideRequests() {
        return List.of();
    }
}


