package org.example.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.models.VehicleType;

import java.util.Date;

@Getter
@Setter
@Builder
public class IssueTicketRequest {
    private String vehicleRegistrationNumber;
    private long gateId;
    private VehicleType vehicleType;
}
