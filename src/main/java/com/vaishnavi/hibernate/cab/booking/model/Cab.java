package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cab {
    private int cabId;
    private String cabNumber;
    private String cabModel;
    private String cabType;
    private String licensePlate;
    private int driverId;
}


