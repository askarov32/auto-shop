package spring.boot.auto_shop.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @PreAuthorize("isAnonymous()")
    @GetMapping("/sign-in")
    public String login() {
        return "sign-in";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/forbidden")
    public String forbidden() {
        return "forbidden";
    }
}
