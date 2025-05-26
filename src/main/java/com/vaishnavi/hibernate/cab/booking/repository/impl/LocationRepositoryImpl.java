package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Location;
import com.vaishnavi.hibernate.cab.booking.repository.LocationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("locationRepository")
public class LocationRepositoryImpl implements LocationRepository {

    private final SessionFactory sessionFactory;

    public LocationRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Location save(Location location) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(location);
        session.getTransaction().commit();
        session.close();
        return location;
    }

    @Override
    public List<Location> findAll() {
        Session session = sessionFactory.openSession();
        Query<Location> query = session.createQuery("from Location", Location.class);
        return query.list();
    }

    @Override
    public Optional<Location> findById(int id) {
        Session session = sessionFactory.openSession();
        Location location = session.get(Location.class, id);
        return Optional.ofNullable(location);
    }

    @Override
    public Location deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Location location = session.load(Location.class, id);
        session.delete(location);
        session.getTransaction().commit();
        session.close();
        return location;
    }
}


