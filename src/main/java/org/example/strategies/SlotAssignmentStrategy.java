package org.example.strategies;

import org.example.models.Gate;
import org.example.models.ParkingSlot;
import org.example.models.VehicleType;

public interface SlotAssignmentStrategy {

    ParkingSlot getSpot(Long parkingLotId , Gate gate, VehicleType vehicleType);
}
