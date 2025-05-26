package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.BookingHistory;

import java.util.List;
import java.util.Optional;

public interface BookingHistoryRepository {
    BookingHistory save(BookingHistory bookingHistory);
    List<BookingHistory> findAll();
    Optional<BookingHistory> findById(int id);
    BookingHistory deleteById(int id);
}


