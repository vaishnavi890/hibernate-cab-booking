package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.PaymentNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Payment;
import com.vaishnavi.hibernate.cab.booking.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment deletePayment(int id) {
        return paymentRepository.deleteById(id);
    }

    public Payment retrievePayment(int id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isEmpty()) {
            throw new PaymentNotFoundException("Payment not found");
        }
        return payment.get();
    }

    public List<Payment> retrievePayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int paymentId) {
        return null;
    }

    public List<Payment> getAllPayments() {
        return List.of();
    }
}


