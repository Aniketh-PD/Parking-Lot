package org.example.models;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private Date entryTime;

    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Operator generatedBy;
    private Gate generatedAt;
}
