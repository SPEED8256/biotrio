package dk.kea.project.biotrio.Controller;


import dk.kea.project.biotrio.Domain.Screening;
import dk.kea.project.biotrio.Repository.MovieRepository;
import dk.kea.project.biotrio.Repository.ScreeningRepository;
import dk.kea.project.biotrio.Repository.TheaterRepository;
import dk.kea.project.biotrio.Service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Date;



@Controller
public class ScreeningController {

    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ScreeningService screeningService;

    @GetMapping("/savescreening")
    public String book(Model model) {

        Screening screening1 = new Screening();
        screening1.setMovie(movieRepository.findByMovieId(1));
        screening1.setPrice(111);
        screening1.setTheater(theaterRepository.findById(1));
        screening1.setScreeningDateTime(new Date());
        screeningService.save(screening1);
        return "pay";
    }
}
