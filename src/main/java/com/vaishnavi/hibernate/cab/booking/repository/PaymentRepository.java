package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    List<Payment> findAll();
    Optional<Payment> findById(int id);
    Payment deleteById(int id);
}


