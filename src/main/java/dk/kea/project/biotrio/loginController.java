package dk.kea.project.biotrio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

public class loginController {

    @Autowired


    private CustomerRepository loginRepo;
    Customer customer = new Customer();

    @RequestMapping(value = "/customer-login", method = RequestMethod.GET)
    public ModelAndView onSubmit(@ModelAttribute Customer customer) {

        String userName = customer.getUsername();
        String password = customer.getPassword();

    return ;
    }

    @PostMapping("/updatecustomer")
    public String saveLogedIn(@ModelAttribute Customer customer){

    }


}

