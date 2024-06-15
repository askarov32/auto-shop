package spring.boot.auto_shop.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.auto_shop.models.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
