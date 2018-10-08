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

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final CarService carService;
    private final CustomerService customerService;

    @Autowired
    public TransactionController(TransactionService transactionService,
                                 CarService carService,
                                 CustomerService customerService){
        this.transactionService = transactionService;
        this.carService = carService;
        this.customerService = customerService;
    }

    @GetMapping
    public String showTransactionList(Model model){
        List<Transaction> transactions = transactionService.findAll();
        model.addAttribute("transactions", transactions);
        return "transaction/list";
    }
    @GetMapping("/add")
    public String addTransaction(Model model){
        model.addAttribute("transaction", new Transaction());
        return "transaction/add";
    }

    @GetMapping("/details/{id}")
    public String showDetailsTransaction(@PathVariable("id") Integer id, Model model){
        Transaction transaction = transactionService.getTransaction(id);
        model.addAttribute("transaction", transaction);
        return "transaction/details";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("transaction") Transaction transaction){
        transactionService.save(transaction);
        return "redirect:/transaction";
    }

    @GetMapping("/new")
    public String createTransaction(Model model){
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("idTransporter", new IdTransporter());

        return "transaction/new";

    }

    @PostMapping("/savecreate")
    public String saveCreateTransaction(@ModelAttribute("transaction") Transaction transaction,
                                        @ModelAttribute("idTransporter") IdTransporter idTransporter ){
        transaction.setCar(carService.getCar(idTransporter.getCarID()));
        transaction.setCustomer(customerService.getCustomer(idTransporter.getCustomerID()));
        transactionService.save(transaction);
        return "redirect:/transaction";
    }
    @GetMapping("/buy/{id}")
    public String byIdCar(@PathVariable("id") Integer carID, Model model) {
        IdTransporter transporter = new IdTransporter();
        transporter.setCarID(carID);
        Car car = carService.getCar(carID);

        model.addAttribute("car", car );
        model.addAttribute("idTransporter", transporter);
        return "transaction/buy";
    }

    @PostMapping("/savebuy")
    public String saveBuyTransaction(@ModelAttribute("idTransporter") IdTransporter idTransporter,
                                     @ModelAttribute("car") Car car){
        Transaction transaction = new Transaction();
        car = carService.getCar(car.getCarID());
        car.setSaleStatus(Car.SaleStatus.SOLD);
        carService.save(car);
        transaction.setCar(car);
        transaction.setCustomer(customerService.getCustomer(idTransporter.getCustomerID()));
        transactionService.save(transaction);
        return "redirect:/transaction";
    }

    @GetMapping("/message")
    public String viewMessage(String message, Model model){
        model.addAttribute("message", message);
        return "transaction/message";
    }
}
