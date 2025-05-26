package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Ride;
import com.vaishnavi.hibernate.cab.booking.repository.RideRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {

    private final SessionFactory sessionFactory;

    public RideRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Ride save(Ride ride) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(ride);
        session.getTransaction().commit();
        session.close();
        return ride;
    }

    @Override
    public List<Ride> findAll() {
        Session session = sessionFactory.openSession();
        Query<Ride> query = session.createQuery("from Ride", Ride.class);
        return query.list();
    }

    @Override
    public Optional<Ride> findById(int id) {
        Session session = sessionFactory.openSession();
        Ride ride = session.get(Ride.class, id);
        return Optional.ofNullable(ride);
    }

    @Override
    public Ride deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Ride ride = session.load(Ride.class, id);
        session.delete(ride);
        session.getTransaction().commit();
        session.close();
        return ride;
    }
}


