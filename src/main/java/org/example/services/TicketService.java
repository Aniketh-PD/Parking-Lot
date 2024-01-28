package org.example.services;

import org.example.exceptions.GateNotFoundException;
import org.example.models.Gate;
import org.example.models.Ticket;
import org.example.models.Vehicle;
import org.example.models.VehicleType;
import org.example.repositories.GateRepository;
import org.example.repositories.VehicleRepository;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class TicketService {

    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
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

        ticket.setGeneratedAt(gate.get());
        ticket.setVehicle(savedVehicle);
        ticket.setEntryTime(new Date());
        ticket.setTicketId(String.valueOf(Instant.now().getEpochSecond()));
        ticket.setGeneratedBy(gate.get().getOperator());
        return ticket;
    }
}
