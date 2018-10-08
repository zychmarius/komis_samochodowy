package pl.zychmariusz.komis_samochodowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zychmariusz.komis_samochodowy.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
