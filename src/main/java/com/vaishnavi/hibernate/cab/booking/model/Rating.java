package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private int rating; // assuming out of 5
    private String review;
}


