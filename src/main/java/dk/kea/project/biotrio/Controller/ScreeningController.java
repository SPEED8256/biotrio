package dk.kea.project.biotrio.Controller;


import dk.kea.project.biotrio.Domain.Screening;
import dk.kea.project.biotrio.Repository.MovieRepository;
import dk.kea.project.biotrio.Repository.ScreeningRepository;
import dk.kea.project.biotrio.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ScreeningController {

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @GetMapping("/admin/view-screenings")
    public String viewScreenings(Model m) {

        m.addAttribute("screeningList", screeningRepository.findAll());

        return "show-screenings";
    }


    @GetMapping("admin/add-screening")
    public String addMovie(Model m) {
        m.addAttribute("movies", movieRepository.findAll());
        m.addAttribute("theatres", theaterRepository.findAll());

        m.addAttribute("screeningForm", new Screening());
        return "add-screening";
    }

    @PostMapping("/admin/save-screening")
    public String save(@ModelAttribute Screening screening) {
        screeningRepository.save(screening);
        return "redirect:/admin/view-screenings";
    }


}
