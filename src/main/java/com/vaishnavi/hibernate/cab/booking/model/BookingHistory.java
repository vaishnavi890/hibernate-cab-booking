package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingHistory {
    private int historyId;
    private int userId;
    private int rideId;
    private String bookingDate;
    private String status;
}


