package pl.zychmariusz.komis_samochodowy.model;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class Manager extends Employee {

    @RequestMapping
    public String schowManagerIndex(){
        return "manager/index";
    }
}
