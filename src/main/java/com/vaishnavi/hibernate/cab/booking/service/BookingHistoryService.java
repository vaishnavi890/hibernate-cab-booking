package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.BookingHistoryNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.BookingHistory;
import com.vaishnavi.hibernate.cab.booking.repository.BookingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingHistoryService {

    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;

    public BookingHistory createHistory(BookingHistory history) {
        return bookingHistoryRepository.save(history);
    }

    public BookingHistory deleteHistory(int id) {
        return bookingHistoryRepository.deleteById(id);
    }

    public BookingHistory retrieveHistory(int id) {
        Optional<BookingHistory> history = bookingHistoryRepository.findById(id);
        if (history.isEmpty()) {
            throw new BookingHistoryNotFoundException("Booking history not found");
        }
        return history.get();
    }

    public List<BookingHistory> retrieveHistories() {
        return bookingHistoryRepository.findAll();
    }

    public BookingHistory createBookingHistory(BookingHistory bookingHistory) {
        return bookingHistory;
    }

    public BookingHistory deleteBookingHistory(int bookingHistoryId) {
        return null;
    }

    public BookingHistory getBookingHistoryById(int bookingHistoryId) {
        return null;
    }

    public List<BookingHistory> getAllBookingHistories() {
        return List.of();
    }
}

