package dk.kea.project.biotrio.Repository;

import dk.kea.project.biotrio.Domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findById(int id);
}
