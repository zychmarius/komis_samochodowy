package pl.zychmariusz.komis_samochodowy.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping
    public String showIndex(Model model){
        return "index";
    }
}
