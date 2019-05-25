package dk.kea.project.biotrio.Service;

import dk.kea.project.biotrio.Domain.Screening;

public interface ScreeningService {
    void save(Screening screening);

    Screening findById(int id);
}
