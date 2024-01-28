package org.example.strategies;

import org.example.models.*;
import org.example.repositories.ParkingLotRepository;

import java.util.Optional;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy {
    private ParkingLotRepository parkingLotRepository;
    public RandomSlotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingSlot getSpot(Long parkingLotId, Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLotRepository.findParkingLotById(parkingLotId).get();
        for(ParkingFloor parkingFloor : parkingLot.getFloors()){
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()){
                if(parkingSlot.getVehicleType().equals(vehicleType) && parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}
