package dk.kea.project.biotrio.Controller;


import dk.kea.project.biotrio.Domain.Screening;
import dk.kea.project.biotrio.Repository.MovieRepository;
import dk.kea.project.biotrio.Repository.ScreeningRepository;
import dk.kea.project.biotrio.Repository.TheaterRepository;
import dk.kea.project.biotrio.Service.ScreeningService;
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

    @Autowired
    private ScreeningService screeningService;

    @GetMapping("/admin/view-screenings")
    public String viewScreenings(Model m) {

        m.addAttribute("screeningList", screeningRepository.findAll());

        return "show-screenings";
    }


    @GetMapping("/admin/add-screening")
    public String addScreening(Model m) {
        m.addAttribute("movies", movieRepository.findAll());
        m.addAttribute("theatres", theaterRepository.findAll());

        m.addAttribute("screeningForm", new Screening());
        return "add-screening";
    }

    @PostMapping("/admin/save-screening")
    public String saveScreening(@ModelAttribute Screening screening) {
        screeningService.save(screening);
        return "redirect:/admin/view-screenings";
    }

    @GetMapping("/admin/screening/delete/{id}")
    public String deleteScreening(@PathVariable(name = "id") int id) {
        screeningService.delete(screeningRepository.findById(id));
        return "redirect:/admin/view-screenings";
    }

    @GetMapping("/admin/screening/edit/{id}")
    public String editScreening(Model m, @PathVariable(name = "id") int id){
        m.addAttribute("movies", movieRepository.findAll());
        m.addAttribute("theatres", theaterRepository.findAll());


        Screening screeningToEdit = screeningRepository.findById(id);
        m.addAttribute("screening", screeningToEdit);
        return "edit-screening";
    }

}
