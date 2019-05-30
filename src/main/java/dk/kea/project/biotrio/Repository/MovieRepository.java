package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieId(Integer id);

    List<Movie> findBySpotlight(boolean isSpotlight);
    List<Movie> findByUpcoming(boolean isSpotlight);

    @Query("select s.movie from Screening s where s.screeningDateTime >= NOW()")
    Set<Movie> findCurrent();
}
