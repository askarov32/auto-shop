package spring.boot.auto_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.Car;
import spring.boot.auto_shop.models.CarBody;
import spring.boot.auto_shop.models.Color;
import spring.boot.auto_shop.models.Engine;
import spring.boot.auto_shop.repository.CarBodyRepository;
import spring.boot.auto_shop.repository.CarRepository;
import spring.boot.auto_shop.repository.ColorRepository;
import spring.boot.auto_shop.repository.EngineRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ColorRepository colorRepository;
    private final EngineRepository engineRepository;
    private final CarBodyRepository carBodyRepository;
    @Autowired
    public CarService(CarRepository carRepository, ColorRepository colorRepository, EngineRepository engineRepository, CarBodyRepository carBodyRepository) {
        this.carRepository = carRepository;
        this.colorRepository = colorRepository;
        this.engineRepository = engineRepository;
        this.carBodyRepository  = carBodyRepository;
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

    public Map<String, Set<Object>> getCarAttributes() {
        List<Car> cars = getAllCars();
        Set<String> brandsRent = cars.stream().map(Car::getBrand).collect(Collectors.toSet());
        Set<Integer> yearsRent = cars.stream().map(Car::getYear).collect(Collectors.toSet());
        Set<String> modelsRent = cars.stream().map(Car::getModel).collect(Collectors.toSet());
        Set<Integer> mileRent = cars.stream().map(Car::getMileage).collect(Collectors.toSet());

        Map<String, Set<Object>> attributes = new HashMap<>();
        attributes.put("brandsRent", new HashSet<>(brandsRent));
        attributes.put("yearsRent", new HashSet<>(yearsRent));
        attributes.put("modelsRent", new HashSet<>(modelsRent));
        attributes.put("mileRent", new HashSet<>(mileRent));

        return attributes;
    }

    public Set<String> getCarsBrandForSale() {
        List<Car> cars = getAllCars();
        Set<String> brands = new HashSet<>();
        for (Car car: cars) {
            if (car.getRentOrSale().equals("sale")) {
                brands.add(car.getBrand());
                }
            }
        return brands;
    }

    public Set<String> getCarsBrandForRent() {
        List<Car> cars = getAllCars();
        Set<String> brands = new HashSet<>();
        for (Car car: cars) {
            if (car.getRentOrSale().equals("rent")) {
                brands.add(car.getBrand());
            }
        }
        return brands;
    }
    public Set<Integer> getCarsYearRent() {
        List<Car> cars = carRepository.findAll();
        Set<Integer> years = new HashSet<>();
        for (Car car: cars) {
            if (car.getRentOrSale().equals("rent")) {
                years.add(car.getYear());
            }
        }
        return years;
    }

    public Set<Integer> getCarsYearSale() {
        List<Car> cars = carRepository.findAll();
        Set<Integer> years = new HashSet<>();
        for (Car car: cars) {
            if (car.getRentOrSale().equals("sale")) {
                years.add(car.getYear());
            }
        }
        return years;
    }

    public Set<String> getCarsModelSale() {
        List<Car> cars = getAllCars();
        Set<String> models = new HashSet<>();
        for (Car car: cars) {
            if (car.getRentOrSale().equals("sale"))
                models.add(car.getModel());
        }
        return models;
    }

    public Set<String> getCarsModelRent() {
        List<Car> cars = getAllCars();
        Set<String> models = new HashSet<>();
        for (Car car: cars) {
            if (car.getRentOrSale().equals("rent"))
                models.add(car.getModel());
        }
        return models;
    }

    public List<Integer> getCarsMileageRent() {
        List<Car> cars = getAllCars();
        List<Integer> miles = new ArrayList<>();
        for (Car car : cars) {
            if (car.getRentOrSale().equals("rent")) {
                miles.add(car.getMileage());
            }
        }
        Collections.sort(miles);
        return miles;
    }


    public List<Integer> getCarsMileageSale() {
        List<Car> cars = getAllCars();
        List<Integer> miles = new ArrayList<>();
        for (Car car : cars) {
            if (car.getRentOrSale().equals("sale")) {
                miles.add(car.getMileage());
            }
        }
        Collections.sort(miles);
        return miles;
    }

    public Set<String> getAllBrands() {
        List<Car> cars = getAllCars();
        Set<String> brands = new HashSet<>();
        for (Car car: cars) {
            brands.add(car.getBrand());
        }
        return brands;
    }

    public List<Integer> getAllMileage() {
        List<Car> cars = getAllCars();
        Set<Integer> mileages = new HashSet<>();
        for (Car car: cars) {
            mileages.add(car.getMileage());
        }
        List<Integer> miles = new ArrayList<>(mileages.stream().toList());
        Collections.sort(miles);
        return miles;
    }

    public List<String> getAllColors() {
        List<Color> all_colors = colorRepository.findAll();
        List<String> colors = new ArrayList<>();
        for (Color color: all_colors) {
            colors.add(color.getName().toUpperCase());
        }
        return colors;
    }

    public List<String> getAllEngines() {
        List<Engine> all_engines = engineRepository.findAll();
        List<String> engines = new ArrayList<>();
        for (Engine engine: all_engines) {
            engines.add(engine.getName());
        }
        return engines;
    }

    public Set<String> getAllModels() {
        List<Car> cars = getAllCars();
        Set<String> models = new HashSet<>();
        for (Car car: cars) {
            models.add(car.getModel());
        }
        return models;
    }

    public List<String> getAllCarBodies() {
        List<CarBody> all_bodies = carBodyRepository.findAll();
        List<String> bodies = new ArrayList<>();
        for (CarBody carBody: all_bodies) {
            bodies.add(carBody.getName());
        }
        return bodies;
    }
}
