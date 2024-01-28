package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor {
    private int parkingFloorId;
    private List<ParkingSlot> parkingSlots;
}
