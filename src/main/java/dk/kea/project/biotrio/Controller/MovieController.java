package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.Movie;
import dk.kea.project.biotrio.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepo;

    //mapping movie list for admin view
    @GetMapping("/mymovie")
    public String movie(Model model) {
        List<Movie> movieList = movieRepo.findAll();
        model.addAttribute("movies", movieList);
        return "show-movies";
    }

    //mapping movies for customer view
    @GetMapping("/frontpage")
    public String frontPage() {

        return "front-page";
    }




    @GetMapping("/addmovie")
    public String addMovie(Model m) {
        m.addAttribute("movieform", new Movie());
        return "add-movie";
    }

    @PostMapping("/savemovie")
    //    @ResponseBody
    public String save(@ModelAttribute Movie movie) {
        Movie movieInserted = movieRepo.save(movie);
        return "redirect:/mymovie";
    }

    @GetMapping("/updatemovie/{id}")
    public String updateMovie(@PathVariable(name = "id") int id, Model m) {
        Movie movieData = movieRepo.findByMovieId(id);
        m.addAttribute("movieform", movieData);
        return "update-movie";
    }


    @GetMapping("/moviev")
    @ResponseBody
    public Movie showMovie(int id) {
        Movie movie = movieRepo.findByMovieId(id);
        return movie;
    }

    @PostMapping("/saveupdate")
    public String saveUpdateMovie(@ModelAttribute Movie movie) {
        movieRepo.save(movie);
        return "redirect:/mymovie";
    }

    @GetMapping("/deletemovie/{id}")
    public String deleteMovie(@PathVariable(name = "id") int id) {
        movieRepo.delete(movieRepo.findByMovieId(id));
        return "redirect:/mymovie";
    }
}