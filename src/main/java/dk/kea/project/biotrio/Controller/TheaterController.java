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

    @GetMapping("/theater-info")
    public String showTheaters(Model model) {
        List<Theater> theaterList = theaterRepo.findAll();
        model.addAttribute("theaters", theaterList);
        return "show-theaters";
    }

    @GetMapping("/add-theater")
    public String addTheater(Model model){
        model.addAttribute("theater", new Theater());
        return "add-theater";
    }

    @PostMapping("/save-theater")
    public String save(@ModelAttribute Theater theater) {

        Theater theaterInserted = theaterRepo.save(theater);
        return "redirect:/theater-info";
    }

    @GetMapping("/theater-view")
    @ResponseBody
    public Theater showTheater() {
        Theater theater = theaterRepo.findById(1);
        return theater;
    }

    @GetMapping("/delete-theater/{id}")
    public String deleteTheater(@PathVariable(name = "id") int id) {
        theaterRepo.delete(theaterRepo.findById(id));
        return "redirect:/theater-info";
    }

    @GetMapping("/edit-theater/{id}")
    public String editTheater(Model m, @PathVariable(name = "id") int id){
        Theater theaterToEdit = theaterRepo.findById(id);
        m.addAttribute("theater", theaterToEdit);
        return "edit-theater";
    }

    @PostMapping("/update-theater")
    public String saveEditTheater(@ModelAttribute Theater theater) {
        theaterRepo.save(theater);
        return "redirect:/theater-info";
    }
}