package org.example.services;

import org.example.exceptions.GateNotFoundException;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.strategies.SlotAssignmentStrategy;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class TicketService {

    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final SlotAssignmentStrategy slotAssignmentStrategy;

    private final TicketRepository ticketRepository;
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,SlotAssignmentStrategy slotAssignmentStrategy,TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.slotAssignmentStrategy = slotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }


    public Ticket issueTicket(String vehicleRegistrationNumber , long gateId, VehicleType vehicleType) throws GateNotFoundException {
        /*
        * check if the gate is valid if not throw an exception
        * save the vehicle details vehicleRepository
        * generate ticket
        * save ticket
        * */
        Ticket ticket = new Ticket();

        Optional<Gate> gate = gateRepository.findById(gateId);
        if(gate.isEmpty()){
            throw new GateNotFoundException();
        }

        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleRegistrationNumber);
        Vehicle savedVehicle;
        if(vehicle.isEmpty()){
            Vehicle newVehicle = new Vehicle();
            newVehicle.setVehicleType(vehicleType);
            newVehicle.setVehicleRegistrationNumber(vehicleRegistrationNumber);
            savedVehicle = newVehicle;
        }else{
            savedVehicle = vehicle.get();
        }
        vehicleRepository.save(savedVehicle);


        ParkingSlot parkingSlot = slotAssignmentStrategy.getSpot(1l,gate.get(),vehicleType);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
        parkingSlot.setVehicle(savedVehicle);
        parkingSlot.setVehicleType(savedVehicle.getVehicleType());

        ticket.setGeneratedAt(gate.get());
        ticket.setVehicle(savedVehicle);
        ticket.setEntryTime(new Date());
        ticket.setTicketId(String.valueOf(Instant.now().getEpochSecond()));
        ticket.setGeneratedBy(gate.get().getOperator());
        ticketRepository.savTicket(ticket);
        return ticket;
    }
}
