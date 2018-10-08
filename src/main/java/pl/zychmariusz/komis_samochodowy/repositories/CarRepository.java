package pl.zychmariusz.komis_samochodowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zychmariusz.komis_samochodowy.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    public List<Car> findCarBySaleStaus(Car.SaleStatus saleStatus);
}
