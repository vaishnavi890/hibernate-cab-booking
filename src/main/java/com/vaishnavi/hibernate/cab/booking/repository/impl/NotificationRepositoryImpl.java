package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.Notification;
import com.vaishnavi.hibernate.cab.booking.repository.NotificationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("notificationRepository")
public class NotificationRepositoryImpl implements NotificationRepository {

    private final SessionFactory sessionFactory;

    public NotificationRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Notification save(Notification notification) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(notification);
        session.getTransaction().commit();
        session.close();
        return notification;
    }

    @Override
    public List<Notification> findAll() {
        Session session = sessionFactory.openSession();
        Query<Notification> query = session.createQuery("from Notification", Notification.class);
        return query.list();
    }

    @Override
    public Optional<Notification> findById(int id) {
        Session session = sessionFactory.openSession();
        Notification notification = session.get(Notification.class, id);
        return Optional.ofNullable(notification);
    }

    @Override
    public Notification deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Notification notification = session.load(Notification.class, id);
        session.delete(notification);
        session.getTransaction().commit();
        session.close();
        return notification;
    }
}


