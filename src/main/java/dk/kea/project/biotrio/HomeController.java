package dk.kea.project.biotrio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//drgrdger
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
