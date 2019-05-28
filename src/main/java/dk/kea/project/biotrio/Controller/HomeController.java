package dk.kea.project.biotrio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @GetMapping("/admin")
    public String admin() {
        return "test";
    }
}
