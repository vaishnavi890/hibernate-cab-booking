package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.RideRequest;
import com.vaishnavi.hibernate.cab.booking.repository.RideRequestRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("rideRequestRepository")
public class RideRequestRepositoryImpl implements RideRequestRepository {

    private final SessionFactory sessionFactory;

    public RideRequestRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public RideRequest save(RideRequest rideRequest) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(rideRequest);
        session.getTransaction().commit();
        session.close();
        return rideRequest;
    }

    @Override
    public List<RideRequest> findAll() {
        Session session = sessionFactory.openSession();
        Query<RideRequest> query = session.createQuery("from RideRequest", RideRequest.class);
        return query.list();
    }

    @Override
    public Optional<RideRequest> findById(int id) {
        Session session = sessionFactory.openSession();
        RideRequest rideRequest = session.get(RideRequest.class, id);
        return Optional.ofNullable(rideRequest);
    }

    @Override
    public RideRequest deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        RideRequest rideRequest = session.load(RideRequest.class, id);
        session.delete(rideRequest);
        session.getTransaction().commit();
        session.close();
        return rideRequest;
    }
}


