package pl.zychmariusz.komis_samochodowy.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zychmariusz.komis_samochodowy.model.Car;
import pl.zychmariusz.komis_samochodowy.repositories.CarRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public Car save(Car car){
        if(car.getTestDrivesNumber() == null){
            car.setTestDrivesNumber(0);
        }
        return carRepository.save(car);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car getCar(Integer id){
        return carRepository.findById(id).get();
    }

    public void deleteCar(Integer id){
        carRepository.deleteById(id);
    }
}
