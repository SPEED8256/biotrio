package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Customer;
import dk.kea.project.biotrio.LoginRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    //instance of repository class
    private LoginRepository loginRepo;

    //to get login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "customer-login";
    }

    //checking for login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("customerForm") Customer customer, Model model) {

        List<Customer> customerListUP = loginRepo.findAllCustomers();

        for (Customer customerObj : customerListUP) {
            if (customerObj.getUsername().equals(customer.getUsername())
                    && customerObj.getPassword().equals(customer.getPassword())) {
            }
            //should return a booking page, where the customer (now logged in) continues to book a ticket.
            // As of now returns a test page
            return "login-home";
        }

        model.addAttribute("invalidCredentials", true);

        return "customer-login";
    }


}
