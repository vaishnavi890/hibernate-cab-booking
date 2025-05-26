package com.vaishnavi.hibernate.cab.booking.repository.impl;

import com.vaishnavi.hibernate.cab.booking.config.HibernateConfig;
import com.vaishnavi.hibernate.cab.booking.model.BookingHistory;
import com.vaishnavi.hibernate.cab.booking.repository.BookingHistoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("bookingHistoryRepository")
public class BookingHistoryRepositoryImpl implements BookingHistoryRepository {

    private final SessionFactory sessionFactory;

    public BookingHistoryRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public BookingHistory save(BookingHistory bookingHistory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bookingHistory);
        session.getTransaction().commit();
        session.close();
        return bookingHistory;
    }

    @Override
    public List<BookingHistory> findAll() {
        Session session = sessionFactory.openSession();
        Query<BookingHistory> query = session.createQuery("from BookingHistory");
        return query.list();
    }

    @Override
    public Optional<BookingHistory> findById(int id) {
        Session session = sessionFactory.openSession();
        BookingHistory bookingHistory = (BookingHistory) session.get(BookingHistory.class, id);
        return Optional.ofNullable(bookingHistory);
    }

    @Override
    public BookingHistory deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        BookingHistory bookingHistory = (BookingHistory) session.load(BookingHistory.class, id);
        session.delete(bookingHistory);
        session.getTransaction().commit();
        session.close();
        return bookingHistory;
    }
}

