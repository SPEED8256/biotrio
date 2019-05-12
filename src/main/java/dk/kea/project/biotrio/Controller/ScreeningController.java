package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.Screening;
import dk.kea.project.biotrio.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ScreeningController {

    @Autowired
    private ScreeningRepository screeningRepo;

    @GetMapping("/myscreening")
    public String screening(Model model) {
        List<Screening> screeningList = screeningRepo.findAllScreenings();
        model.addAttribute("screenings", screeningList);
        return "show-screenings";
    }

    @GetMapping("/addscreening")
    public String addScreening(Model m) {
        m.addAttribute("screeningform", new Screening());
        return "add-screening";
    }

    @PostMapping("/savescreening")
    //    @ResponseBody
    public String save(@ModelAttribute Screening screening) {
        Screening screeningInserted = screeningRepo.insert(screening);
        return "redirect:/myscreening";
    }

    @GetMapping("/screeningv")
    @ResponseBody
    public Screening showScreening(int id) {
        Screening screening = screeningRepo.findScreening(id);
        return screening;
    }

    @GetMapping("/updatescreening/{id}")
    public String updateScreening(@PathVariable(name = "id") int id, Model m) {
        Screening screeningData = screeningRepo.findScreening(id);
        m.addAttribute("screeningform", screeningData);
        return "update-screening";
    }

    @PostMapping("/saveupdate")
    public String saveUpdateScreening(@ModelAttribute Screening screening) {
        screeningRepo.update(screening);
        return "redirect:/myscreening";
    }

    @GetMapping("/deletescreening/{id}")
    public String deleteScreening(@PathVariable(name = "id") int id) {
        screeningRepo.delete(id);
        return "redirect:/myscreening";
    }


}