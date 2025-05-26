package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;
}


