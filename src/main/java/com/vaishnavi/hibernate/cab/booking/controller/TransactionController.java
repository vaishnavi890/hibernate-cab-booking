package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.Transaction;
import com.vaishnavi.hibernate.cab.booking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(service.createTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") int transactionId) {
        return new ResponseEntity<>(service.deleteTransaction(transactionId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") int transactionId) {
        return new ResponseEntity<>(service.getTransactionById(transactionId), HttpStatus.OK);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }
}



