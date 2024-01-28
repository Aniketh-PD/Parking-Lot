package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParkingSlot {
    private int slotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private VehicleType vehicleType;
    private ParkingFloor parkingFloor;
    private Vehicle vehicle;
}
