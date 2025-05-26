package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Driver;
import com.vaishnavi.hibernate.cab.booking.repository.DriverRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("driverRepository")
public class DriverRepositoryImpl implements DriverRepository {

    private final SessionFactory sessionFactory;

    public DriverRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Driver save(Driver driver) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(driver);
        session.getTransaction().commit();
        session.close();
        return driver;
    }

    @Override
    public List<Driver> findAll() {
        Session session = sessionFactory.openSession();
        Query<Driver> query = session.createQuery("from Driver", Driver.class);
        return query.list();
    }

    @Override
    public Optional<Driver> findById(int id) {
        Session session = sessionFactory.openSession();
        Driver driver = (Driver) session.get(Driver.class, id);
        return Optional.ofNullable(driver);
    }

    @Override
    public Driver deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Driver driver = (Driver) session.load(Driver.class, id);
        session.delete(driver);
        session.getTransaction().commit();
        session.close();
        return driver;
    }
}

