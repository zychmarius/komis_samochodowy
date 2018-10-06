package pl.zychmariusz.komis_samochodowy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zychmariusz.komis_samochodowy.model.Transaction;
import pl.zychmariusz.komis_samochodowy.services.TransactionService;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
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

    @PostMapping("/save")
    public String save(@ModelAttribute("transaction") Transaction transaction){
        transactionService.save(transaction);
        return "redirect:/transaction";
    }

}
