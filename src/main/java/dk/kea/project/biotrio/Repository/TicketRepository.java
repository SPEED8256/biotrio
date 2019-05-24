package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findById(int id);

}