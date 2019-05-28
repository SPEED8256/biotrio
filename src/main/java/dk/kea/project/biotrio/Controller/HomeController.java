package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.Movie;
import dk.kea.project.biotrio.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieRepository movieRepository;

    //mapping movie list for customer view
    @GetMapping("/")
    public String frontPage(Model model){
        List<Movie> movieList = movieRepository.findAll();
        model.addAttribute("movies", movieList);
        return "front-page";
    }
    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @GetMapping("/admin")
    public String admin() {
        return "test";
    }
}
