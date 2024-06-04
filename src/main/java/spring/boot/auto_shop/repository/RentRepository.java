package spring.boot.auto_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.auto_shop.models.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
