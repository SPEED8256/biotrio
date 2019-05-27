package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieId(Integer id);

}
