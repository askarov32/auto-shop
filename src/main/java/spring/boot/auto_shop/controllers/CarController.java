package spring.boot.auto_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.boot.auto_shop.models.Car;
import spring.boot.auto_shop.repository.CarRepository;
import spring.boot.auto_shop.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping("/car")
    public String carPage() {
        return "car";
    }

    @GetMapping("/blog")
    public String blogPage() {
        return "blog";
    }

    @GetMapping("/blog-details")
    public String blogDetailsPage() {
        return "blog-details";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/car-details")
    public String carDetailsPage() {
        return "car-details";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}
