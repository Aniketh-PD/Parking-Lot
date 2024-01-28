package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate {
    private long gateId;
    private GateType gateType;

    private Operator operator;

}
