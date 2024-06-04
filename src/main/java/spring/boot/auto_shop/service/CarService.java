package spring.boot.auto_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.Car;
import spring.boot.auto_shop.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getMoreCars(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return carRepository.findAll(pageable).getContent();
    }

    public List<Car> getCars(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return carRepository.findAll(pageable).getContent();
    }


}