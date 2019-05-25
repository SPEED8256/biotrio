package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Booking;
import dk.kea.project.biotrio.Domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

}