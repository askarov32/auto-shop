package spring.boot.auto_shop.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.auto_shop.models.Car;
import spring.boot.auto_shop.models.Color;
import spring.boot.auto_shop.service.CarService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/show-cars")
    public String showCars(@RequestParam("page") int page, Model model) {
        List<Car> cars = carService.getCars(page, 8);
        model.addAttribute("cars", cars);
        return "fragments/car :: carListFragment";
    }

    @GetMapping("/load-more-cars")
    public String loadMoreCars(@RequestParam("page") int page, Model model) {
        int pageSize = 8;
        List<Car> moreCars = carService.getMoreCars(page, pageSize);
        model.addAttribute("cars", moreCars);
        return "fragments/car :: carListFragment";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/car-details")
    public String carDetailsPage() {
        return "car-details";
    }

    @GetMapping("/car")
    public String carPage(Model model) {
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
        return "car";
    }
}
