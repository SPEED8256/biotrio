package dk.kea.project.biotrio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {



        @Autowired
        private CustomerRepository customerRepo;

        @GetMapping("/customers-info")
        public String Customer(Model model){
            List<Customer> customerList = customerRepo.findAllCustomers();
            model.addAttribute("customer", customerList);
            return "show-car";
        }


        @GetMapping("/new-user")
        public String addCustomer(Model m){
            m.addAttribute("carform", new Customer());
            return "new-customer";
        }

        @PostMapping("/save-customer")
        public String saveCar(@ModelAttribute Customer customer){

            Customer customerCreated = customerRepo.insert(customer);
            return "redirect:/customers info";
        }


        @GetMapping("/customer-view")
        @ResponseBody
        public Customer showCustomer(){
            Customer customer = customerRepo.findCustomer(1);
            return customer;
        }

        @GetMapping("/delete-customer/{id}")
        public String deleteCustomer(@PathVariable(name = "id") int id){
            customerRepo.delete(id);
            return "redirect:/        ";
        }

    }

