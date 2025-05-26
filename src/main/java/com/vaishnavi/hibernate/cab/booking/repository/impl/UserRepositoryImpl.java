package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.User;
import com.vaishnavi.hibernate.cab.booking.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    public UserRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        return query.list();
    }

    @Override
    public Optional<User> findById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public User deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
}


