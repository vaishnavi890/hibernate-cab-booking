package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Transaction;
import com.vaishnavi.hibernate.cab.booking.repository.TransactionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("transactionRepository")
public class TransactionRepositoryImpl implements TransactionRepository {

    private final SessionFactory sessionFactory;

    public TransactionRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Transaction save(Transaction transaction) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(transaction);
        session.getTransaction().commit();
        session.close();
        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        Session session = sessionFactory.openSession();
        Query<Transaction> query = session.createQuery("from Transaction", Transaction.class);
        return query.list();
    }

    @Override
    public Optional<Transaction> findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.get(Transaction.class, id);
        return Optional.ofNullable(transaction);
    }

    @Override
    public Transaction deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.load(Transaction.class, id);
        session.delete(transaction);
        session.getTransaction().commit();
        session.close();
        return transaction;
    }
}


