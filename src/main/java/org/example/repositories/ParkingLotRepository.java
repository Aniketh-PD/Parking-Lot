package org.example.repositories;

import org.example.models.ParkingLot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotRepository {
    private HashMap<Long, ParkingLot> parkingLot = new HashMap<>();

    public Optional<ParkingLot> findParkingLotById(Long parkingLotId){
        if(parkingLot.containsKey(parkingLotId)){
            return Optional.of(parkingLot.get(parkingLotId));
        }
        return Optional.empty();
    }
}
