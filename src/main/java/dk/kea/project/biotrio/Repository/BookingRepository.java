package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Booking;
import dk.kea.project.biotrio.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findAllByUser(User user);

}