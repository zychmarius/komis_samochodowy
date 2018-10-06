package pl.zychmariusz.komis_samochodowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zychmariusz.komis_samochodowy.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
