package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    private int locationId;
    private String address;
    private String city;
    private String state;
    private String zipCode;
}


