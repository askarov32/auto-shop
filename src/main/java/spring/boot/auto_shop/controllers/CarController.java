package spring.boot.auto_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.auto_shop.models.Car;
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
        List<Car> cars = carService.getCars(1, 8);
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
}
