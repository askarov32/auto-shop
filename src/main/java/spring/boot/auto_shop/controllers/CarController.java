package spring.boot.auto_shop.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.auto_shop.models.Car;
import spring.boot.auto_shop.service.CarService;

import java.util.List;
import java.util.Set;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car-info")
    public String getCarDetails(@RequestParam("id") Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "car-info";
    }

    @GetMapping("/car")
    public String carPage(Model model,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Car> carPage = carService.getAllCarsPage(pageable);
        List<Car> cars = carService.getAllCars();
        List<Integer> miles = carService.getAllMileage();
        List<String> colors = carService.getAllColors();
        List<String> engines = carService.getAllEngines();
        Set<String> brands = carService.getAllBrands();
        Set<String> models = carService.getAllModels();
        List<String> car_bodies = carService.getAllCarBodies();

        model.addAttribute("brands", brands);
        model.addAttribute("cars", cars);
        model.addAttribute("miles", miles);
        model.addAttribute("colors", colors);
        model.addAttribute("engines", engines);
        model.addAttribute("models", models);
        model.addAttribute("car_bodies", car_bodies);
        model.addAttribute("carPage", carPage);
        return "car";
    }
}
