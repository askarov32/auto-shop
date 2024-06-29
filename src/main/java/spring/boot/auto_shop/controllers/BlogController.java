package spring.boot.auto_shop.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.auto_shop.models.Blog;
import spring.boot.auto_shop.service.BlogService;

import java.util.List;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("/blog")
    public String blogPage(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogList1", blogs);
        return "blog";
    }

    @GetMapping("/blog-info")
    public String blogInfo(@RequestParam("id") int id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog-info";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/blog-details")
    public String blogDetails() {
        return "blog-details";
    }

    @GetMapping("/show-blogs")
    public String listBlogs(Model model) {
        model.addAttribute("blogListFr", blogService.getAllBlogs());
        return "fragments/blog :: blogListFragment";
    }
}
