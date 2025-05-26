package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> findAll();
    Optional<Transaction> findById(int id);
    Transaction deleteById(int id);
}

