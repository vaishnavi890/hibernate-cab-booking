package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideRequest {
    private int requestId;
    private int userId;
    private String pickupLocation;
    private String dropoffLocation;
    private String status;
}


