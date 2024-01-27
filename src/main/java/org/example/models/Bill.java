package org.example.models;

import java.util.Date;

public class Bill {
    private String billId;
    private Date exitTime;

    private Ticket ticket;
    private Gate generatedAt;
    private Operator generatedBy;
    private PaymentType paymentType;
}
