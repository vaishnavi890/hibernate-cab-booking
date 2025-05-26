package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.DriverNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Driver;
import com.vaishnavi.hibernate.cab.booking.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver deleteDriver(int id) {
        return driverRepository.deleteById(id);
    }

    public Driver retrieveDriver(int id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if (driver.isEmpty()) {
            throw new DriverNotFoundException("Driver not found");
        }
        return driver.get();
    }

    public List<Driver> retrieveDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(int driverId) {
        return null;
    }

    public List<Driver> getAllDrivers() {
        return List.of();
    }
}


