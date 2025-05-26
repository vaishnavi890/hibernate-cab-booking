package com.vaishnavi.hibernate.cab.booking.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    private int transactionId;
    private int paymentId;
    private double amount;
    private String transactionDate;
    private String transactionType;
}



