package com.vaishnavi.hibernate.cab.booking.controller;

import com.vaishnavi.hibernate.cab.booking.model.Notification;
import com.vaishnavi.hibernate.cab.booking.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return new ResponseEntity<>(service.createNotification(notification), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notification> deleteNotification(@PathVariable("id") int notificationId) {
        return new ResponseEntity<>(service.deleteNotification(notificationId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable("id") int notificationId) {
        return new ResponseEntity<>(service.getNotificationById(notificationId), HttpStatus.OK);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return service.getAllNotifications();
    }
}


