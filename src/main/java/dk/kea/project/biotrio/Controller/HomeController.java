package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

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
                "bradd pitt, angelina jolie", 111);
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
        seatsRow1.add(new Seat(8));
        seatsRow1.add(new Seat(9));
        seatsRow1.add(new Seat(10));


        ArrayList<Row> rows = new ArrayList <>();
//        rows.add(new Row(1, seatsRow1));
//        rows.add(new Row(2, seatsRow2));
//        rows.add(new Row(4, seatsRow3));
//        rows.add(new Row(5, seatsRow3));

        Seat[] seatsArray = new Seat[20];
        seatsArray[0] = (new Seat(1));
        seatsArray[1] = (new Seat(2));
        seatsArray[2] = (new Seat(3));
        seatsArray[3] = (new Seat(4));
        seatsArray[4] = (new Seat(5));
        seatsArray[5] = (new Seat(6));
        seatsArray[6] = (new Seat(7, true));
        seatsArray[7] = (new Seat(8));
        seatsArray[8] = (new Seat(9));
        seatsArray[9] = (new Seat(10));
        seatsArray[10] = (new Seat(11));
        seatsArray[11] = (new Seat(12));
        seatsArray[12] = (new Seat(13));
        seatsArray[13] = (new Seat(14));
        seatsArray[14] = (new Seat(15));
        seatsArray[15] = (new Seat(16));
        seatsArray[16] = (new Seat(17, true));
        seatsArray[17] = (new Seat(18));
        seatsArray[18] = (new Seat(19));
        seatsArray[19] = (new Seat(20));


        rows.add(new Row(1, seatsArray));
        rows.add(new Row(2, seatsArray));
        rows.add(new Row(3, seatsArray));
        rows.add(new Row(4, seatsArray));
        rows.add(new Row(5, seatsArray));
        rows.add(new Row(6, seatsArray));
        rows.add(new Row(7, seatsArray));
        rows.add(new Row(8, seatsArray));
        rows.add(new Row(9, seatsArray));
        rows.add(new Row(10, seatsArray));
        rows.add(new Row(11, seatsArray));
        rows.add(new Row(12, seatsArray));
        rows.add(new Row(13, seatsArray));
        rows.add(new Row(14, seatsArray));

        Theater theater = new Theater(1,"lol",  rows);

        model.addAttribute("theater", theater);
        return "book";

    }

    @RequestMapping(value="/booking/post/",method = RequestMethod.POST)
    public String postSeats(@RequestBody String jsonString){
        return jsonString;
    }
}
