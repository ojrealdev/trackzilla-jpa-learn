package com.keysoft.bucktrackerjpa.dao;

import com.keysoft.bucktrackerjpa.entity.Ticket;

import java.util.List;

public interface ITicketDAO {
    List<Ticket> getAllTickets();
    void addTicket(Ticket ticket);
    Ticket getTicketById(int ticketId);
    void updateTicket(Ticket ticket);
    void deleteTicket(int ticketId);
    void closeTicket(int ticketId);
}

