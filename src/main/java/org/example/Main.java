package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.IssueTicketRequest;
import org.example.dtos.IssueTicketResponse;
import org.example.models.VehicleType;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.services.TicketService;
import org.example.strategies.RandomSlotAssignmentStrategy;
import org.example.strategies.SlotAssignmentStrategy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SlotAssignmentStrategy slotAssignmentStrategy = new RandomSlotAssignmentStrategy(parkingLotRepository);
        TicketService ticketService = new TicketService(gateRepository,vehicleRepository,slotAssignmentStrategy,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        ticketController.issueTicket(
                IssueTicketRequest.builder()
                        .gateId(1l)
                        .vehicleType(VehicleType.CAR).
                        vehicleRegistrationNumber("KA-01 HU 8900").build());
    }
}