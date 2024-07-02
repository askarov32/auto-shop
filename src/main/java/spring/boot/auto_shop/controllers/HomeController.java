package spring.boot.auto_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.auto_shop.models.Blog;
import spring.boot.auto_shop.models.Car;
import spring.boot.auto_shop.service.BlogService;
import spring.boot.auto_shop.service.CarService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class HomeController {

    private final CarService carService;
    private final BlogService blogService;

    @Autowired
    public HomeController(CarService carService, BlogService blogService) {
        this.carService = carService;
        this.blogService = blogService;
    }

    @Transactional
    @GetMapping("/")
    public String getIndexPage(Model model) {
        List<Car> cars = carService.getAllCars().subList(0, 8);
        List<Blog> blogs = blogService.getAllBlogs();

        Map<String, Object> carAttributes = carService.getCarAttributes();

        for (Blog blog1 : blogs) {
            if (blog1.getContent().length() > 255) {
                blog1.setContent(blog1.getContent().substring(0, 255) + "...");
            }
        }

        model.addAttribute("cars", cars);
        model.addAttribute("blogList", blogs);
        model.addAttribute("cars_brands_rent", carAttributes.get("brandsRent"));
        model.addAttribute("cars_years_rent", carAttributes.get("yearsRent"));
        model.addAttribute("cars_model_rent", carAttributes.get("modelsRent"));
        model.addAttribute("cars_mile_rent", carAttributes.get("mileRent"));
        model.addAttribute("cars_brands_sale", carAttributes.get("brandsSale"));
        model.addAttribute("cars_years_sale", carAttributes.get("yearsSale"));
        model.addAttribute("cars_model_sale", carAttributes.get("modelsSale"));
        model.addAttribute("cars_mile_sale", carAttributes.get("mileRent"));

        return "index";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }


}
