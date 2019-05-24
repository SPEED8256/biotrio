//package dk.kea.project.biotrio.Controller;
//
//import dk.kea.project.biotrio.Domain.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Controller
//public class HomeController {
//
//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }
//
//    @GetMapping("/booking")
//    public String book(Model model){
//        return "booking";
//
//    }
//
//    @RequestMapping(path="/booking", method= RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public String postBooking(@RequestBody Booking booking){
//
//        return "redirect:/pay";
//
//    }
//
//    @RequestMapping(path = "/pay")
//    public String pay(){
//        return "pay";
//    }
//}
