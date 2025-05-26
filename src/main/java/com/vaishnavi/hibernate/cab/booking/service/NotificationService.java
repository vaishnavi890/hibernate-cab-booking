package com.vaishnavi.hibernate.cab.booking.service;

import com.vaishnavi.hibernate.cab.booking.exception.NotificationNotFoundException;
import com.vaishnavi.hibernate.cab.booking.model.Notification;
import com.vaishnavi.hibernate.cab.booking.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification deleteNotification(int id) {
        return notificationRepository.deleteById(id);
    }

    public Notification retrieveNotification(int id) {
        Optional<Notification> notif = notificationRepository.findById(id);
        if (notif.isEmpty()) {
            throw new NotificationNotFoundException("Notification not found");
        }
        return notif.get();
    }

    public List<Notification> retrieveNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(int notificationId) {
        return null;
    }

    public List<Notification> getAllNotifications() {
        return List.of();
    }
}


