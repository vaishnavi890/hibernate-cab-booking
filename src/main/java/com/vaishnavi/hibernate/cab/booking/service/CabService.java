package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.CabNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Cab;
import com.vaishnavi.hibernate.cab.booking.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabService {

    @Autowired
    private CabRepository cabRepository;

    public Cab createCab(Cab cab) {
        return cabRepository.save(cab);
    }

    public Cab deleteCab(int id) {
        return cabRepository.deleteById(id);
    }

    public Cab retrieveCab(int id) {
        Optional<Cab> cab = cabRepository.findById(id);
        if (cab.isEmpty()) {
            throw new CabNotFoundException("Cab not found");
        }
        return cab.get();
    }

    public List<Cab> retrieveCabs() {
        return cabRepository.findAll();
    }

    public Cab getCabById(int cabId) {
        return null;
    }

    public List<Cab> getAllCabs() {
        return List.of();
    }
}


