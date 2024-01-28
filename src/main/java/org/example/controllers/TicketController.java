package org.example.controllers;

import org.example.dtos.IssueTicketRequest;
import org.example.dtos.IssueTicketResponse;
import org.example.exceptions.GateNotFoundException;
import org.example.models.Ticket;
import org.example.services.TicketService;

public class TicketController {

    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public IssueTicketResponse issueTicket(IssueTicketRequest issueTicketRequest){
        Ticket issuedTicket  = null;
        try {
            issuedTicket = ticketService.issueTicket(issueTicketRequest.getVehicleRegistrationNumber(), issueTicketRequest.getGateId(), issueTicketRequest.getVehicleType());
        } catch (GateNotFoundException e) {
            throw new RuntimeException(e);
        }
        IssueTicketResponse ticketResponse = IssueTicketResponse.builder()
                                             .ticketNumber(issuedTicket.getTicketId())
                                             .entryTime(issuedTicket.getEntryTime())
                                             .floorNumber(issuedTicket.getParkingSlot().getParkingFloor().getParkingFloorId())
                                             .gateNumber(issuedTicket.getGeneratedAt().getGateId())
                                             .vehicleNumber(issuedTicket.getVehicle().getVehicleRegistrationNumber())
                                             .build();
        return ticketResponse;
    }
}
