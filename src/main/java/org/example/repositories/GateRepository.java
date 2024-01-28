package org.example.repositories;

import org.example.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gates = new HashMap<>();

    public Optional<Gate> findById(long gateNumber){
        if(gates.containsKey(gateNumber)){
            return Optional.of(gates.get(gateNumber));
        }
        return Optional.empty();
    }
}
