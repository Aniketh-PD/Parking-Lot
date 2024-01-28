package org.example.exceptions;

public class GateNotFoundException extends  Exception{
    public  GateNotFoundException(){
        super("Gate Id is not valid");
    }
}
