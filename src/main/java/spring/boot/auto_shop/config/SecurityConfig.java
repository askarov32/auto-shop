package spring.boot.auto_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;
import spring.boot.auto_shop.repository.UserRepository;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetails(){
        return email -> {
            var user = userRepository.findByEmail(email);
            if(user==null){
                throw new UsernameNotFoundException("User Not Found");
            } else return user;
        };
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetails()).passwordEncoder(passwordEncoder());

        http.csrf(AbstractHttpConfigurer::disable);

        http.exceptionHandling(eh -> eh.accessDeniedPage("/forbidden"));

        http.formLogin(fl ->
                fl.loginProcessingUrl("/auth")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .loginPage("/sign-in")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/sign-in?error"));

        http.logout(lg -> lg.logoutUrl("/log-out").logoutSuccessUrl("/sign-in"));

        return http.build();
    }


}
