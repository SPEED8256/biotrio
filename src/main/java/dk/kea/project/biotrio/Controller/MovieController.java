package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.Movie;
import dk.kea.project.biotrio.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepo;

    @GetMapping("/mymovie")
    public String movie(Model model) {
        List<Movie> movieList = movieRepo.findAllMovies();
        model.addAttribute("movies", movieList);
        return "show-movies";
    }

    @GetMapping("/addmovie")
    public String addMovie(Model m) {
        m.addAttribute("movieform", new Movie());
        return "add-movie";
    }

    @PostMapping("/savemovie")
    //    @ResponseBody
    public String save(@ModelAttribute Movie movie) {
        Movie movieInserted = movieRepo.insert(movie);
        return "redirect:/mymovie";
    }

    @GetMapping("/updatemovie/{id}")
    public String updateMovie(@PathVariable(name = "id") int id, Model m) {
        Movie movieData = movieRepo.findMovie(id);
        m.addAttribute("movieform", movieData);
        return "update-movie";
    }


    @GetMapping("/moviev")
    @ResponseBody
    public Movie showMovie(int id) {
        Movie movie = movieRepo.findMovie(id);
        return movie;
    }

    @PostMapping("/saveupdate")
    public String saveUpdateMovie(@ModelAttribute Movie movie) {
        movieRepo.update(movie);
        return "redirect:/mymovie";
    }

    @GetMapping("/deletemovie/{id}")
    public String deleteMovie(@PathVariable(name = "id") int id) {
        movieRepo.delete(id);
        return "redirect:/mymovie";
    }
}