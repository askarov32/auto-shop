package spring.boot.auto_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.boot.auto_shop.repository.CarRepository;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "index";
    }


}
