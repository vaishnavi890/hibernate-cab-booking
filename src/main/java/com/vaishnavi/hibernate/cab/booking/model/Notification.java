package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    private int notificationId;
    private int userId;
    private String message;
    private String timestamp;
    private boolean isRead;
}


