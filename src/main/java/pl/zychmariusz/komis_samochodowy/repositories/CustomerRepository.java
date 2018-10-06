package pl.zychmariusz.komis_samochodowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zychmariusz.komis_samochodowy.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
