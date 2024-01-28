package org.example.models;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class Ticket {
    private String ticketId;
    private Date entryTime;

    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Operator generatedBy;
    private Gate generatedAt;
}
