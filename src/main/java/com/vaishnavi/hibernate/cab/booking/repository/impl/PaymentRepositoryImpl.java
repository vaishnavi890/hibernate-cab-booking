package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Payment;
import com.vaishnavi.hibernate.cab.booking.repository.PaymentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("paymentRepository")
public class PaymentRepositoryImpl implements PaymentRepository {

    private final SessionFactory sessionFactory;

    public PaymentRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Payment save(Payment payment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(payment);
        session.getTransaction().commit();
        session.close();
        return payment;
    }

    @Override
    public List<Payment> findAll() {
        Session session = sessionFactory.openSession();
        Query<Payment> query = session.createQuery("from Payment", Payment.class);
        return query.list();
    }

    @Override
    public Optional<Payment> findById(int id) {
        Session session = sessionFactory.openSession();
        Payment payment = session.get(Payment.class, id);
        return Optional.ofNullable(payment);
    }

    @Override
    public Payment deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Payment payment = session.load(Payment.class, id);
        session.delete(payment);
        session.getTransaction().commit();
        session.close();
        return payment;
    }
}


