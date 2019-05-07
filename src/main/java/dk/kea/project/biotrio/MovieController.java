package dk.kea.project.biotrio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MovieController {

    @Autowired
    private MovieRepository movieRepo;

    @GetMapping("/mymovie")
    public String movie(Model model) {
        List<Movie> movieList = movieRepo.findAllMovies();
        model.addAttribute("movies", movieList);
        return "show-movie";
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

    @GetMapping("/moviev")
    @ResponseBody
    public Movie showMovie(int id) {
        Movie movie = movieRepo.findMovie(id);
        return movie;
    }

    @GetMapping("/updatemovie/{id}")
    public String updateMovie(@PathVariable(name = "id") int id, Model m) {
        Movie movieData = movieRepo.findMovie(id);
        m.addAttribute("movieform", movieData);
        return "update-movie";
    }

    @PostMapping("/saveupdate")
    public String saveUpdateCar(@ModelAttribute Movie movie) {
        movieRepo.update(movie);
        return "redirect:/mycar";
    }

    @GetMapping("/deletecar/{id}")
    public String deleteMovie(@PathVariable(name = "id") int id) {
        movieRepo.delete(id);
        return "redirect:/mymovie";
    }


}
