package pl.zychmariusz.komis_samochodowy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zychmariusz.komis_samochodowy.model.Contract;
import pl.zychmariusz.komis_samochodowy.repositories.ContractRepository;

@Service
public class ContranctService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContranctService(ContractRepository contractRepository){
        this.contractRepository = contractRepository;
    }

    public Contract save(Contract contract){
        return contractRepository.save(contract);
    }

}
