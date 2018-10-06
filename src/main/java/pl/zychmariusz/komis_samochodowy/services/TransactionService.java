package pl.zychmariusz.komis_samochodowy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zychmariusz.komis_samochodowy.model.Car;
import pl.zychmariusz.komis_samochodowy.model.Transaction;
import pl.zychmariusz.komis_samochodowy.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public Transaction getTransaction(Integer id){
        return transactionRepository.findById(id).get();
    }

    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }


}
