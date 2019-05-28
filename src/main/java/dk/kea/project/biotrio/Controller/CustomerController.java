package dk.kea.project.biotrio.Controller;

import dk.kea.project.biotrio.Repository.CustomerRepository;
import dk.kea.project.biotrio.Domain.Customer;
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
        model.addAttribute("customers", customerList);
        return "show-customers";
    }


    @GetMapping("/new-user")
    public String addCustomer(Model m){
        m.addAttribute("customerform", new Customer());
        return "new-customer";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute Customer customer){

        Customer customerCreated = customerRepo.insert(customer);
        return "redirect:/customers-info";
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
        return "redirect:/customers-info";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(Model m, @PathVariable(name = "id") int id){
        Customer customerToEdit = customerRepo.findCustomer(id);
        m.addAttribute("customerform", customerToEdit);
        return "edit-customer";
    }


    @PostMapping("/update-customer")
    public String saveEditCustomer(@ModelAttribute Customer customer){
        customerRepo.update(customer);
        return "redirect:/customers-info";
    }
}


