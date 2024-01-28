package org.example.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class IssueTicketResponse {
    private int spotNumber;
    private int floorNumber;
    private String ticketNumber;
    private Date entryTime;
    private long gateNumber;
    private String vehicleNumber;

}
