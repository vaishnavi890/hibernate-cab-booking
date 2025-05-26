package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.Cab;

import java.util.List;
import java.util.Optional;

public interface CabRepository {
    Cab save(Cab cab);
    List<Cab> findAll();
    Optional<Cab> findById(int id);
    Cab deleteById(int id);
}

