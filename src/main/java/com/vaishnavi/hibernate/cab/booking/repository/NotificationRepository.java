package com.vaishnavi.hibernate.cab.booking.repository;

import com.vaishnavi.hibernate.cab.booking.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {

    Notification save(Notification notification);
    List<Notification> findAll();
    Optional<Notification> findById(int id);
    Notification deleteById(int id);
}

