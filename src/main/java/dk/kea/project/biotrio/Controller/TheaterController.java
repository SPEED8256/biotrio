package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.Theater;
import dk.kea.project.biotrio.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepo;

    @GetMapping("/admin/theater-info")
    public String showTheaters(Model model) {
        List<Theater> theaterList = theaterRepo.findAll();
        model.addAttribute("theaters", theaterList);
        return "show-theaters";
    }

    @GetMapping("/admin/add-theater")
    public String addTheater(Model model) {
        model.addAttribute("theater", new Theater());
        return "add-theater";
    }

    @PostMapping("/admin/save-theater")
    public String save(@ModelAttribute Theater theater) {

        Theater theaterInserted = theaterRepo.save(theater);
        return "redirect:/admin/theater-info";
    }

    @GetMapping("/admin/theater/{id}")
    @ResponseBody
    public Theater showTheater(@PathVariable(name = "id") int id) {
        Theater theater = theaterRepo.findById(id);
        return theater;
    }

    @GetMapping("/admin/delete-theater/{id}")
    public String deleteTheater(@PathVariable(name = "id") int id) {
        theaterRepo.delete(theaterRepo.findById(id));
        return "redirect:/admin/theater-info";
    }

    @GetMapping("/admin/edit-theater/{id}")
    public String editTheater(Model m, @PathVariable(name = "id") int id) {
        Theater theaterToEdit = theaterRepo.findById(id);
        m.addAttribute("theater", theaterToEdit);
        return "edit-theater";
    }

    @PostMapping("/admin/update-theater")
    public String saveEditTheater(@ModelAttribute Theater theater) {
        theaterRepo.save(theater);
        return "redirect:/admin/theater-info";
    }
}