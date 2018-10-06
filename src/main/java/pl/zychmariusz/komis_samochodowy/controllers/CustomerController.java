package pl.zychmariusz.komis_samochodowy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zychmariusz.komis_samochodowy.model.Customer;
import pl.zychmariusz.komis_samochodowy.services.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public String showCustomerIndex(){
        return "customer/index";
    }

    @GetMapping("/list")
    public String showCustomerList(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/add")
    public String schowAddCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomer(@PathVariable("id") Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomer(id));
        return "customer/edit";
    }

    @GetMapping("details/{id}")
    public String showDetailsCustomer(@PathVariable("id") Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomer(id));
        return "customer/id";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteByIdCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
    //metodausuniecia
}
