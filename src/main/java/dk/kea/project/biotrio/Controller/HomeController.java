package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/booking")
    public String book(Model model){
        Movie movie = new Movie(1, "test movie", "22222", "test genre", "test year",
                "test origin", 100, "james camearon",
                "bradd pitt, angelina jolie", 111.00);
        model.addAttribute("movie", movie);

        Customer customer = new Customer(1 , "username", "password", "name" , LocalDate.now(),
                "email", "phoneNumber", "paymentDetails");
        model.addAttribute("customer", customer);


        ArrayList<Seat> seatsRow1 = new ArrayList<>();
        seatsRow1.add(new Seat(1));
        seatsRow1.add(new Seat(2));
        seatsRow1.add(new Seat(3));
        seatsRow1.add(new Seat(4));
        seatsRow1.add(new Seat(5));
        seatsRow1.add(new Seat(6));
        seatsRow1.add(new Seat(7));
        seatsRow1.add(new Seat(8));
        seatsRow1.add(new Seat(9));
        seatsRow1.add(new Seat(10));

        ArrayList<Seat> seatsRow2 = new ArrayList<>();
        seatsRow1.add(new Seat(11));
        seatsRow1.add(new Seat(12));
        seatsRow1.add(new Seat(13));
        seatsRow1.add(new Seat(14));
        seatsRow1.add(new Seat(15));
        seatsRow1.add(new Seat(16));
        seatsRow1.add(new Seat(17));
        seatsRow1.add(new Seat(18));
        seatsRow1.add(new Seat(19));
        seatsRow1.add(new Seat(20));

        ArrayList<Seat> seatsRow3 = new ArrayList<>();
        seatsRow1.add(new Seat(1));
        seatsRow1.add(new Seat(2));
        seatsRow1.add(new Seat(3));
        seatsRow1.add(new Seat(4));
        seatsRow1.add(new Seat(5));
        seatsRow1.add(new Seat(6));
        seatsRow1.add(new Seat(7));
        seatsRow1.add(new Seat(8));
        seatsRow1.add(new Seat(9));
        seatsRow1.add(new Seat(10));


        ArrayList<Row> rows = new ArrayList <>();
        rows.add(new Row(1, seatsRow1));
        rows.add(new Row(2, seatsRow2));
        rows.add(new Row(4, seatsRow3));
        rows.add(new Row(5, seatsRow3));
        rows.add(new Row(6, seatsRow3));


        Theater theater = new Theater(1, rows);
        model.addAttribute("theater", theater);
        return "book";

    }
}
