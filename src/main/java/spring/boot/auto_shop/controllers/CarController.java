package spring.boot.auto_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.auto_shop.models.Blog;
import spring.boot.auto_shop.models.Car;
import spring.boot.auto_shop.service.BlogService;
import spring.boot.auto_shop.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;
    private final BlogService blogService;

    @Autowired
    public CarController(CarService carService, BlogService blogService) {
        this.carService = carService;
        this.blogService = blogService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) {
        List<Car> cars = carService.getCars(1, 8);
        List<Blog> blogs = blogService.getAllBlogs();
        for (Blog blog1 : blogs) {
            if (blog1.getContent().length() > 255) {
                blog1.setContent(blog1.getContent().substring(0, 255) + "...");
            }
        }
        model.addAttribute("cars", cars);
        model.addAttribute("blogList", blogs);
        return "index";
    }

    @GetMapping("/car")
    public String carPage() {
        return "car";
    }

    @GetMapping("/blog")
    public String blogPage(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogList1", blogs);
        return "blog";
    }


    @GetMapping("/blog-details")
    public String blogDetails(@RequestParam("id") int id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
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

    @GetMapping("/show-blogs")
    public  String listBlogs(Model model) {
        model.addAttribute("blogListFr", blogService.getAllBlogs());
        return "fragments/blog :: blogListFragment";
    }

}
