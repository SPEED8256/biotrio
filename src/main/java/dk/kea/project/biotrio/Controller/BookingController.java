package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.*;
import dk.kea.project.biotrio.Repository.*;
import dk.kea.project.biotrio.Service.ScreeningService;
import dk.kea.project.biotrio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/booking/{screeningId}")
    public String book(Model model, Principal principal, @PathVariable int screeningId){
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("customer", user);

        Screening screening = screeningRepository.findById(screeningId);

        model.addAttribute("screening", screening);

        ArrayList<ArrayList<Ticket>> rows = new ArrayList<>();
        for (int i = 0; i<screening.getTheater().getRows(); i++){
        rows.add(new ArrayList<Ticket>());
        }

        for(Ticket ticket : screening.getTickets()){
            for (int r = 1; r<=screening.getTheater().getRows(); r++){
                if (ticket.getTicketRow()==r){
                    rows.get(r-1).add(ticket);
                }
            }
        }

        model.addAttribute("rows",rows);
        model.addAttribute("theater", screening.getTheater());
        model.addAttribute("movie", screening.getMovie());
        return "booking";

    }

    @RequestMapping(path="/booking", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void postBooking(@RequestBody BookingInfo bookinginfo){


        System.out.println(bookinginfo.getCustomerId());
        System.out.println(bookinginfo.getScreeningId());
        System.out.println(bookinginfo.getTickets().length);

        List<Ticket> tickets = new ArrayList<>();
        for (Ticket t : bookinginfo.getTickets()
             ) {
            Ticket ticketToUpdate = ticketRepository.getOne(t.getId());
            ticketToUpdate.setTicketStatus(true);
            ticketRepository.save(ticketToUpdate);


            tickets.add(ticketToUpdate);
        }

        Booking booking = new Booking();

        booking.setScreening(screeningRepository.findById(bookinginfo.getScreeningId()));
        booking.setUser(userRepository.findById((long) bookinginfo.getCustomerId()).get());
        booking.setTickets(tickets);
        bookingRepository.save(booking);


    }

}
