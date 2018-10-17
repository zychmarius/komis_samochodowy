package pl.zychmariusz.komis_samochodowy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zychmariusz.komis_samochodowy.model.Car;
import pl.zychmariusz.komis_samochodowy.model.Contract;
import pl.zychmariusz.komis_samochodowy.model.Customer;
import pl.zychmariusz.komis_samochodowy.model.Transaction;
import pl.zychmariusz.komis_samochodowy.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;
    private final CarService carService;
    private final CustomerService customerService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository,
                              CarService carService,
                              CustomerService customerService){
        this.transactionRepository = transactionRepository;
        this.carService = carService;
        this.customerService = customerService;
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

    public Transaction saveBuy(Car car, Customer customer){
        Transaction transaction = new Transaction();
        Contract contract = new Contract();
        contract.setContractType(Contract.ContractType.SALE);
        contract.setContentContract("standardowa umowa");
        contract.setAmount(car.getPrice());
        car = carService.getCar(car.getCarID());
        car.setSaleStatus(Car.SaleStatus.SOLD);
        customer = customerService.getCustomer(customer.getCustomerID());
        transaction.setCar(car);
        transaction.setCustomer(customer);
        transaction.setContract(contract);
        return transactionRepository.save(transaction);
    }


}
