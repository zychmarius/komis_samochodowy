package pl.zychmariusz.komis_samochodowy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zychmariusz.komis_samochodowy.model.Car;
import pl.zychmariusz.komis_samochodowy.services.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;


    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }


    @GetMapping("/list")
    public String showCarList( Model model){
        model.addAttribute("cars", carService.findAll());
       return "car/list";
    }


    @GetMapping("/details/{id}")
    public String showCarId(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("tytul", "costam");
        return "car/id";
    }

    @GetMapping("/add")
    public String showAddCar(Model model){
        model.addAttribute("car", new Car());
       return "car/add";
    }

    @GetMapping("/edit/{id}")
    public String showEditCarById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carService.getCar(id));
        return "car/edit";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car){
        carService.save(car);
        return "redirect:/car/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id){
        carService.deleteCar(id);
        return "redirect:/car/list";
    }
}
