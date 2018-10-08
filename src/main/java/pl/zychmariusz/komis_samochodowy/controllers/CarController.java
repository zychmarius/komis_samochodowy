package pl.zychmariusz.komis_samochodowy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zychmariusz.komis_samochodowy.model.Car;
import pl.zychmariusz.komis_samochodowy.model.IdTransporter;
import pl.zychmariusz.komis_samochodowy.model.Transaction;
import pl.zychmariusz.komis_samochodowy.services.CarService;
import pl.zychmariusz.komis_samochodowy.services.CustomerService;
import pl.zychmariusz.komis_samochodowy.services.TransactionService;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final TransactionService transactionService;
    private final CustomerService customerService;


    @Autowired
    public CarController(CarService carService,
                         TransactionService transactionService,
                         CustomerService customerService){
        this.carService = carService;
        this.transactionService = transactionService;
        this.customerService = customerService;
    }

    @RequestMapping
    public String showCarIndex(){
        return "car/index";
    }


    @GetMapping("/list")
    public String showAvailableCarList( Model model){
        model.addAttribute("cars", carService.findAvailableCar());
       return "car/list";
    }
    @GetMapping("/soldlist")
    public String showSoldCarList( Model model){
        model.addAttribute("cars", carService.findSoldCar());
        return "car/list";
    }


    @GetMapping("/details/{id}")
    public String showCarId(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carService.getCar(id));
        return "car/id";
    }

    @GetMapping("/add")
    public String showAddCar(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("idTransporter", new IdTransporter());
       return "car/add";
    }

    @GetMapping("/edit/{id}")
    public String showEditCarById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carService.getCar(id));

        return "car/edit";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car, @ModelAttribute("idTransporter") IdTransporter idTransporter){
        Transaction transaction = new Transaction();
        transaction.setCar(car);
        transaction.setCustomer(customerService.getCustomer(idTransporter.getCustomerID()));
        transactionService.save(transaction);
        return "redirect:/car";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id){
        carService.deleteCar(id);
        return "redirect:/car/list";
    }
}
