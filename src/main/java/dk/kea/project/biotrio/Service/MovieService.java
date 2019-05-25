package dk.kea.project.biotrio.Service;

import dk.kea.project.biotrio.Domain.Movie;

public interface MovieService {
    void save(Movie user);

    Movie findByTitle(String title);
}