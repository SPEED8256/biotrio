package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.Movie;
import dk.kea.project.biotrio.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private MovieRepository movieRepository;

    //mapping movie list for customer view
    @GetMapping("/")
    public String frontPage(Model model) {
        List<Movie> spotlightList = movieRepository.findBySpotlight(true);
        model.addAttribute("spotlightMovies", spotlightList);

        List<Movie> upcomingList = movieRepository.findByUpcoming(true);
        model.addAttribute("upcomingMovies", upcomingList);

        Set<Movie> currentList = movieRepository.findCurrent();
        System.out.println(currentList.size());
        model.addAttribute("currentMovies", currentList);

        return "front-page";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
