package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.Theater;
import dk.kea.project.biotrio.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepo;

    @GetMapping("/my-theater")
    public String theater(Model model) {
        List<Theater> theaterList = theaterRepo.findAllTheaters();
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
        Theater theaterInserted = theaterRepo.insert(theater);
        return "redirect:/my-theater";
    }

    @GetMapping("/theater-view")
    @ResponseBody
    public Theater showTheater(int id) {
        Theater theater = theaterRepo.findTheater(id);
        return theater;
    }

    @PostMapping("/update-theater")
    public String saveUpdateTheater(@ModelAttribute Theater theater) {
        theaterRepo.update(theater);
        return "redirect:/my-theater";
    }

    @GetMapping("/delete-theater/{id}")
    public String deleteTheater(@PathVariable(name = "id") int id) {
        theaterRepo.delete(id);
        return "redirect:/my-theater";
    }
}