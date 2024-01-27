package org.example.models;

import java.util.List;

public class ParkingLot {
    private String parkingLotId;
    private List<ParkingFloor> floors;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
}
