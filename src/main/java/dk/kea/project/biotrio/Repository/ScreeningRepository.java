package dk.kea.project.biotrio.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dk.kea.project.biotrio.Domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findById(int id);
}
