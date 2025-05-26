package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.LocationNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Location;
import com.vaishnavi.hibernate.cab.booking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location deleteLocation(int id) {
        return locationRepository.deleteById(id);
    }

    public Location retrieveLocation(int id) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isEmpty()) {
            throw new LocationNotFoundException("Location not found");
        }
        return location.get();
    }

    public List<Location> retrieveLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(int locationId) {
        return null;
    }

    public List<Location> getAllLocations() {
        return List.of();
    }
}

