package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.BookingRepository;
import dk.kea.project.biotrio.Domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository bookingRepo;

    @GetMapping("/mybooking")
    public String booking(Model model) {
        List<Booking> bookingList = bookingRepo.findAllBookings();
        model.addAttribute("bookings", bookingList);
        return "show-bookings";
    }

    @GetMapping("/addbooking")
    public String addBooking(Model m) {
        m.addAttribute("bookingform", new Booking());
        return "add-booking";
    }

    @PostMapping("/savebooking")
    //    @ResponseBody
    public String save(@ModelAttribute Booking booking) {
        Booking bookingInserted = bookingRepo.insert(booking);
        return "redirect:/mybooking";
    }

    @GetMapping("/adminv")
    @ResponseBody
    public Booking showBooking(int id) {
        Booking booking = bookingRepo.findBooking(id);
        return booking;
    }

    @GetMapping("/deletebooking/{id}")
    public String deletebooking(@PathVariable(name = "id") int id) {
        bookingRepo.delete(id);
        return "redirect:/mybooking";
    }



}
