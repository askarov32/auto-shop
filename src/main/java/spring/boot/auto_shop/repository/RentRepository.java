package spring.boot.auto_shop.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.auto_shop.models.Rent;

@Repository
@Transactional
public interface RentRepository extends JpaRepository<Rent, Long> {
}
