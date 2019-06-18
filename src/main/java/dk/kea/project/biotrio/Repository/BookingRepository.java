package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Booking;
import dk.kea.project.biotrio.Domain.Screening;
import dk.kea.project.biotrio.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findAllByUser(User user);

    Booking findById(String id);

    void deleteAllByScreening(Screening screening);

    @Query("select b from Booking b where b.user = ?1 and b.bookingDateTime = (SELECT MAX(b.bookingDateTime) FROM Booking b where b.user = ?1)")
    List<Booking> findLastBooking(User user);

}