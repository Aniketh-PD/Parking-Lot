package org.example.repositories;


import org.example.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public Optional<Vehicle> findById(String vehicleRegistrationNumber){
        if(vehicles.containsKey(vehicleRegistrationNumber)){
            return Optional.of(vehicles.get(vehicleRegistrationNumber));
        }
        return Optional.empty();
    }
    public void save(Vehicle vehicle){
        if(!vehicles.containsKey(vehicle.getVehicleRegistrationNumber())){
            vehicles.put(vehicle.getVehicleRegistrationNumber(),vehicle);
        }
    }
}
