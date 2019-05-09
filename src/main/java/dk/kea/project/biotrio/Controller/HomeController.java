package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/booking")
    public String book(Model model){



        ArrayList<Seat> seatsRow1 = new ArrayList<>();
        seatsRow1.add(new Seat(1, false));
        seatsRow1.add(new Seat(2, false));
        seatsRow1.add(new Seat(3, false));
        seatsRow1.add(new Seat(4, false));
        seatsRow1.add(new Seat(5, false));
        seatsRow1.add(new Seat(6, false));
        seatsRow1.add(new Seat(7, false));
        seatsRow1.add(new Seat(8, false));
        seatsRow1.add(new Seat(9, false));
        seatsRow1.add(new Seat(10, false));
        seatsRow1.add(new Seat(11, false));
        seatsRow1.add(new Seat(12, false));
        seatsRow1.add(new Seat(13, false));
        seatsRow1.add(new Seat(14, false));
        seatsRow1.add(new Seat(15, false));
        seatsRow1.add(new Seat(16, false));
        seatsRow1.add(new Seat(17, false));
        seatsRow1.add(new Seat(18, false));
        seatsRow1.add(new Seat(19, false));
        seatsRow1.add(new Seat(20, false));

        ArrayList<Seat> seatsRow2 = new ArrayList<>();
        seatsRow2.add(new Seat(1, false));
        seatsRow2.add(new Seat(2, false));
        seatsRow2.add(new Seat(3, false));
        seatsRow2.add(new Seat(4, false));
        seatsRow2.add(new Seat(5, false));
        seatsRow2.add(new Seat(6, false));
        seatsRow2.add(new Seat(7, false));
        seatsRow2.add(new Seat(8, false));
        seatsRow2.add(new Seat(9, false));
        seatsRow2.add(new Seat(10, false));
        seatsRow2.add(new Seat(11, false));
        seatsRow2.add(new Seat(12, false));
        seatsRow2.add(new Seat(13, false));
        seatsRow2.add(new Seat(14, false));
        seatsRow2.add(new Seat(15, false));
        seatsRow2.add(new Seat(16, false));
        seatsRow2.add(new Seat(17, false));
        seatsRow2.add(new Seat(18, false));
        seatsRow2.add(new Seat(19, false));
        seatsRow2.add(new Seat(20, false));

        Seat seat = new Seat();

        ArrayList<Seat> seatsRow3 = new ArrayList<>();
        seatsRow3.add(new Seat(1, false));
        seatsRow3.add(new Seat(2, false));
        seatsRow3.add(new Seat(3, false));
        seatsRow3.add(new Seat(4, false));
        seatsRow3.add(new Seat(5, false));
        seatsRow3.add(new Seat(6, false));
        seatsRow3.add(new Seat(7, false));
        seatsRow3.add(new Seat(8, false));
        seatsRow3.add(new Seat(9, false));
        seatsRow3.add(new Seat(10, false));
        seatsRow3.add(new Seat(11, false));
        seatsRow3.add(new Seat(12, false));
        seatsRow3.add(new Seat(13, false));
        seatsRow3.add(new Seat(14, false));
        seatsRow3.add(new Seat(15, false));
        seatsRow3.add(new Seat(16, false));
        seatsRow3.add(new Seat(17, false));
        seatsRow3.add(new Seat(18, false));
        seatsRow3.add(new Seat(19, false));
        seatsRow3.add(new Seat(20, false));


        ArrayList<Row> rows = new ArrayList <>();
        rows.add(new Row(1, seatsRow1));
        rows.add(new Row(2, seatsRow2));
        rows.add(new Row(3, seatsRow3));
        rows.add(new Row(4, seatsRow3));
        rows.add(new Row(5, seatsRow3));
        rows.add(new Row(6, seatsRow3));
        rows.add(new Row(7, seatsRow3));
        rows.add(new Row(8, seatsRow3));
        rows.add(new Row(9, seatsRow3));
        rows.add(new Row(10, seatsRow3));
        rows.add(new Row(11, seatsRow3));
        rows.add(new Row(12, seatsRow3));
        rows.add(new Row(13, seatsRow3));
        rows.add(new Row(14, seatsRow3));


        Theater theater = new Theater(1,"The Blue Theater)",  rows);
        model.addAttribute("theater", theater);

        Movie movie = new Movie(1, "test movie", "22222", "test genre", "test year",
                "test origin", 100, "james camearon",
                "bradd pitt, angelina jolie");
        model.addAttribute("movie", movie);

        Screening screening = new Screening(1, LocalDateTime.now(), 100, movie, theater);
        model.addAttribute("screening", screening);

        Customer customer = new Customer(1 , "username", "password", "name" , LocalDate.now(),
                "email", "phoneNumber", "paymentDetails");
        model.addAttribute("customer", customer);

        return "book";

    }

    @RequestMapping(path="/booking", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String postBooking(@RequestBody Booking booking){

        System.out.println(booking.getCustomerId());
        System.out.println(booking.getScreeningId());
        System.out.println(booking.getTickets().length);
//        for (int i =0; i<tickets.length; i++ )
//        {
//            System.out.println("row:"+tickets[i].getRow()+" seat:"+tickets[i].getSeat());
//        }


        return "redirect:/pay";

    }

    @RequestMapping(path = "/pay")
    public String pay(){
        return "pay";
    }
}
