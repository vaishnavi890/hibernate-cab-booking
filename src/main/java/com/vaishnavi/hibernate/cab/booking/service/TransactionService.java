package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.TransactionNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Transaction;
import com.vaishnavi.hibernate.cab.booking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction deleteTransaction(int id) {
        return transactionRepository.deleteById(id);
    }

    public Transaction retrieveTransaction(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isEmpty()) {
            throw new TransactionNotFoundException("Transaction not found");
        }
        return transaction.get();
    }

    public List<Transaction> retrieveTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(int transactionId) {
        return null;
    }

    public List<Transaction> getAllTransactions() {
        return List.of();
    }
}



