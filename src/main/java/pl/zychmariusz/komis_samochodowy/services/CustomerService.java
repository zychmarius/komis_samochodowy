package pl.zychmariusz.komis_samochodowy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zychmariusz.komis_samochodowy.model.Customer;
import pl.zychmariusz.komis_samochodowy.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Integer id){
        return customerRepository.findById(id).get();
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }
}
