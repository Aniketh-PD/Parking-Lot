package org.example.repositories;

import org.example.models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<String, Ticket> tickets = new HashMap<>();

    public Optional<Ticket> findbyTicketId(String ticketId){
        if(tickets.containsKey(ticketId)){
            return Optional.of(tickets.get(ticketId));
        }
        return Optional.empty();
    }
    public void savTicket(Ticket ticket){
        if(!tickets.containsKey(ticket.getTicketId())){
            tickets.put(ticket.getTicketId(),ticket);
        }
    }
}
