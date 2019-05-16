package dk.kea.project.biotrio.Controller;


import dk.kea.project.biotrio.Domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    //to get login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "customer-login";
    }

    //checking for login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("customerForm") Customer customer, Model model) {
        if (customer.getUsername().equals("admin") && customer.getPassword().equals("admin")) {
            //should return a booking page, where the customer (now logged in). As of now returns a test page
            return "login-home";
        }
        model.addAttribute("invalidCredentials", true);

        return "customer-login";
    }


}
