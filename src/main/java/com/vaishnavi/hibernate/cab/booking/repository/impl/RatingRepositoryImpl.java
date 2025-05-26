package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Rating;
import com.vaishnavi.hibernate.cab.booking.repository.RatingRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("ratingRepository")
public class RatingRepositoryImpl implements RatingRepository {

    private final SessionFactory sessionFactory;

    public RatingRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Rating save(Rating rating) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(rating);
        session.getTransaction().commit();
        session.close();
        return rating;
    }

    @Override
    public List<Rating> findAll() {
        Session session = sessionFactory.openSession();
        Query<Rating> query = session.createQuery("from Rating", Rating.class);
        return query.list();
    }

    @Override
    public Optional<Rating> findById(int id) {
        Session session = sessionFactory.openSession();
        Rating rating = session.get(Rating.class, id);
        return Optional.ofNullable(rating);
    }

    @Override
    public Rating deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Rating rating = session.load(Rating.class, id);
        session.delete(rating);
        session.getTransaction().commit();
        session.close();
        return rating;
    }
}


