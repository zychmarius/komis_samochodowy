package pl.zychmariusz.komis_samochodowy.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping
    public String showEmployeeIndex(){
        return "employee/index";
    }

    @GetMapping("/list")
    public String showEmployeeList(){
    return "employee/list";
    }

    @GetMapping("/{id}")
    public String showIdEmployee(@PathVariable("id") Integer id){
        return "employee/id";
    }
}
