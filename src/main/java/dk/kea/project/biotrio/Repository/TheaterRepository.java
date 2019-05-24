package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findById(int id);

}