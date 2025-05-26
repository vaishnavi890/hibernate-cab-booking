package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Cab;
import com.vaishnavi.hibernate.cab.booking.repository.CabRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("cabRepository")
public class CabRepositoryImpl implements CabRepository {

    private final SessionFactory sessionFactory;

    public CabRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Cab save(Cab cab) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cab);
        session.getTransaction().commit();
        session.close();
        return cab;
    }

    @Override
       public List<Cab> findAll() {
        Session session = sessionFactory.openSession();
        Query<Cab> query = session.createQuery("from Cab", Cab.class);
       return query.list();
    }

    @Override
    public Optional<Cab> findById(int id) {
        Session session = sessionFactory.openSession();
        Cab cab = (Cab) session.get(Cab.class, id);
        return Optional.ofNullable(cab);
    }

    @Override
    public Cab deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cab cab = (Cab) session.load(Cab.class, id);
        session.delete(cab);
        session.getTransaction().commit();
        session.close();
        return cab;
    }
}

