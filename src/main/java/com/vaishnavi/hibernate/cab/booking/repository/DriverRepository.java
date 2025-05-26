package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverRepository {
    Driver save(Driver driver);
    List<Driver> findAll();
    Optional<Driver> findById(int id);
    Driver deleteById(int id);
}


