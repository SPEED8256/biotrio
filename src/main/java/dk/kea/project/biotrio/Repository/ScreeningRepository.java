package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Movie;
import dk.kea.project.biotrio.Domain.Screening;
import dk.kea.project.biotrio.Domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findById(int id);

    List<Screening> findAllByMovieAndScreeningDateTimeAfter(Movie movie, Date today);

    void deleteAllByMovie(Movie movie);

    void deleteAllByTheater(Theater theater);

}
