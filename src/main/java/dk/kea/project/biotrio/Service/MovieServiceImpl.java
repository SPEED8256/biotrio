package dk.kea.project.biotrio.Service;

import dk.kea.project.biotrio.Domain.Movie;
import dk.kea.project.biotrio.Repository.MovieRepository;
import dk.kea.project.biotrio.Repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieServiceImpl implements MovieService{

    @Autowired
    ScreeningRepository screeningRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public void delete(Movie movie){
        screeningRepository.deleteAllByMovie(movie);
        movieRepository.delete(movie);
    }
}
