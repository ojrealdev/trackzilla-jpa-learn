package com.keysoft.bucktrackerjpa.dao;

import com.keysoft.bucktrackerjpa.entity.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TicketDAO implements ITicketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Ticket> getAllTickets() {
        //note Ticket is the class name; not the table name; class name is case sensitive; use class field names - column names
        String query = "select t from Ticket t order by t.title";
        return (List<Ticket>) entityManager.createQuery(query).getResultList();
    }

    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    public Ticket getTicketById(int ticketId) {
        return entityManager.find(Ticket.class, ticketId);
    }

    public void updateTicket(Ticket ticket) {
        Ticket ticket1 = getTicketById(ticket.getId());

        ticket1.setDescription(ticket.getDescription());
        ticket1.setApplication(ticket.getApplication());
        ticket1.setTitle(ticket.getTitle());

        entityManager.flush();
    }

    public void deleteTicket(int ticketId) {
        entityManager.remove(getTicketById(ticketId));

    }

    public void closeTicket(int ticketId) {
        Ticket ticket = getTicketById(ticketId);
        ticket.setStatus("Resolved");
    }
}
