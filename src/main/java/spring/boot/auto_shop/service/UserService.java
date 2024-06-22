package spring.boot.auto_shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.User;
import spring.boot.auto_shop.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
